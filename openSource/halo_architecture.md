## Halo 오픈소스 아키텍처 설계 공부

<hr>

### 서론

실제 동작하는 서비스의 구조를 공부함으로서 프로젝트의 퀄리티를 올려보겠습니다.

지금까지 항상 하던데로 구현했었는데 새로운 인사이트를 얻는 것이 목표입니다.

저번 큐시즘 면접에서 레이어드 아키텍처 이외에 다른 방안은 고려한 적이 없는지 물어봤었는데
제대로 답변하지 못한게 아쉬워서 오픈소스를 통한 공부가 필요하다고 생각했습니다.

<hr>

### Halo란?

> 현대적인 오픈소스 블로그/CMS 플랫폼

**주요 특징**:
- Spring WebFlux 기반 비동기/논블로킹 처리
- Kubernetes-style Resource Management
- 버전 관리 시스템 (Snapshot 기반)
- 함수형 라우팅 패턴

<hr>

### 아키텍처 개요

#### 실제 Halo의 아키텍처 특징

**핵심 아키텍처**:
1. **Extension-Based Architecture**: Kubernetes-style 리소스 관리
2. **Reactive Programming**: Spring WebFlux 기반 비동기 처리  
3. **Functional Endpoints**: 전통적인 Controller 대신 함수형 라우팅
4. **Content Versioning**: Snapshot 기반 버전 관리 시스템

```
┌─────────────────────────────────────────────────────────────┐
│                    Frontend Layer                           │
│           (Console UI + Theme System)                       │
└─────────────────────┬───────────────────────────────────────┘
                      │ HTTP Requests
┌─────────────────────┴───────────────────────────────────────┐
│                Functional Endpoints                         │
│           (PostEndpoint, UserEndpoint...)                   │
└─────────────────────┬───────────────────────────────────────┘
                      │ Business Logic Calls
┌─────────────────────┴───────────────────────────────────────┐
│                  Service Layer                              │
│            (PostService, UserService...)                    │
│                 + Event System                              │
└─────────────────────┬───────────────────────────────────────┘
                      │ Data Access
┌─────────────────────┴───────────────────────────────────────┐
│              Extension System                               │
│        (Post, User, Category... Extensions)                 │
│              + Reactor Database                             │
└─────────────────────────────────────────────────────────────┘
```

<hr>

### Extension 기반 도메인 설계 (실제 Post.java)

#### 1. Post 도메인 모델 (실제 코드)
```java
@Data
@EqualsAndHashCode(callSuper = true)
@GVK(group = Constant.GROUP, version = Constant.VERSION, 
     kind = Post.KIND, plural = "posts", singular = "post")
public class Post extends AbstractExtension {
    
    public static final String KIND = "Post";
    
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private PostSpec spec;
    
    @Schema
    private PostStatus status;

    @Data
    public static class PostSpec {
        @Schema(requiredMode = Schema.RequiredMode.REQUIRED, minLength = 1)
        private String title;
        
        @Schema(requiredMode = Schema.RequiredMode.REQUIRED, minLength = 1)
        private String slug;
        
        @Schema(defaultValue = "false")
        private Boolean deleted = false;
        
        @Schema(defaultValue = "true")
        private Boolean publish = true;
        
        @Schema(defaultValue = "PUBLIC")
        private VisibleEnum visible = VisibleEnum.PUBLIC;
        
        @Schema
        private List<String> categories;
        
        @Schema
        private List<String> tags;
    }

    @Data
    public static class PostStatus {
        @Schema
        private PostPhase phase;
        
        @Schema
        private String permalink;
        
        @Schema
        private Long commentsCount;
        
        @Schema
        private Instant lastModifyTime;
    }
    
    public enum PostPhase {
        DRAFT, PUBLISHED
    }
    
    public enum VisibleEnum {
        PUBLIC, INTERNAL, PRIVATE
    }
}
```

**핵심 설계 패턴**:
- **@GVK 애노테이션**: Kubernetes-style 리소스 정의
- **Spec-Status 패턴**: 원하는 상태(spec)와 실제 상태(status) 분리
- **Extension 기반**: AbstractExtension을 상속하여 확장성 제공

#### 2. 반응형 Service Layer
```java
@Component
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    
    private final ReactiveExtensionClient client;
    private final ContentService contentService;
    
    @Override
    public Mono<Post> draftPost(PostRequest postRequest) {
        return contentService.draftContent(postRequest.getPost().getMetadata().getName(),
                postRequest.getContent(), postRequest.getContent().getRaw())
            .flatMap(contentWrapper -> {
                var post = postRequest.getPost();
                post.getSpec().setHeadSnapshot(contentWrapper.getSnapshotName());
                post.getSpec().setReleaseSnapshot(contentWrapper.getSnapshotName());
                return client.create(post);
            });
    }
    
    @Override
    public Mono<Post> updatePost(Post post) {
        return updatePostWithRetry(post);
    }
    
    private Mono<Post> updatePostWithRetry(Post post) {
        return client.update(post)
            .onErrorResume(OptimisticLockingFailureException.class, ex -> 
                client.get(Post.class, post.getMetadata().getName())
                    .map(latest -> {
                        post.getMetadata().setVersion(latest.getMetadata().getVersion());
                        return post;
                    })
                    .flatMap(this::updatePostWithRetry)
            )
            .retryWhen(Retry.backoff(5, Duration.ofMillis(100))
                .filter(OptimisticLockingFailureException.class::isInstance));
    }
    
    @Override
    public Mono<Post> publish(Post post) {
        return Mono.defer(() -> {
                var spec = post.getSpec();
                spec.setPublish(true);
                spec.setPublishTime(Instant.now());
                return client.update(post);
            });
    }
}
```

**핵심 반응형 패턴**:
- **Mono/Flux**: 비동기 데이터 스트림 처리
- **Retry 메커니즘**: 실패 시 자동 재시도
- **함수형 체이닝**: flatMap, map을 통한 데이터 변환 파이프라인
- **에러 복구**: onErrorResume을 통한 에러 처리

#### 3. 함수형 Endpoint Layer
```java
@Component
@RequiredArgsConstructor
public class PostEndpoint implements CustomEndpoint {
    
    private final PostService postService;
    
    @Override
    public RouterFunction<ServerResponse> endpoint() {
        return SpringdocRouteBuilder.route()
            .POST("posts", this::draftPost,
                builder -> builder.operationId("DraftPost")
                    .description("Draft a post")
                    .tag(tag)
                    .requestBody(requestBodyBuilder()
                        .required(true)
                        .content(contentBuilder()
                            .mediaType(APPLICATION_JSON_VALUE)
                            .schema(schemaBuilder()
                                .implementation(PostRequest.class))))
                    .response(responseBuilder()
                        .implementation(Post.class)))
                        
            .PUT("posts/{name}", this::updatePost,
                builder -> builder.operationId("UpdateDraftPost")
                    .description("Update a post")
                    .tag(tag)
                    .parameter(parameterBuilder()
                        .name("name")
                        .description("Post name")
                        .required(true))
                    .requestBody(requestBodyBuilder()
                        .required(true)
                        .content(contentBuilder()
                            .mediaType(APPLICATION_JSON_VALUE)
                            .schema(schemaBuilder().implementation(PostRequest.class))))
                    .response(responseBuilder().implementation(Post.class)))
                    
            .PUT("posts/{name}/publish", this::publishPost,
                builder -> builder.operationId("PublishPost")
                    .description("Publish a post")
                    .tag(tag))
            .build();
    }
    
    private Mono<ServerResponse> draftPost(ServerRequest request) {
        return request.bodyToMono(PostRequest.class)
            .flatMap(postService::draftPost)
            .flatMap(post -> ServerResponse.ok().bodyValue(post));
    }
    
    private Mono<ServerResponse> publishPost(ServerRequest request) {
        String name = request.pathVariable("name");
        return postService.getByName(name)
            .flatMap(postService::publish)
            .flatMap(post -> ServerResponse.ok().bodyValue(post));
    }
}
```

**함수형 라우팅 특징**:
- **RouterFunction**: 선언적 라우팅 정의
- **Mono<ServerResponse>**: 반응형 응답 처리  
- **SpringdocRouteBuilder**: OpenAPI 문서 자동 생성
- **함수형 체이닝**: request → business logic → response 파이프라인

<hr>

