### PSA(Portable Service Abstraction)이란?

<hr>

### Portable Service Abstraction
> 환경에 변화와 관계 없이 일관된 방식의 기술로의 접근 환경을 제공하는 추상화 구조

* 이렇게 보면 정확하게 어떻게 쓰이는지 모르겠다 하나씩 알아가보자.

#### Service Abstraction
> 실제로 서비스에서 사용되는 부분의 정보만을 제공하고, 불필요한 정보는 제공하지 않는다.

* 서비스 추상화: 추상화 계층을 통하여 어떤 기술을 내부적으로 숨기고, 개발자에게 편의를 제공해 주는 것
* 특정 기술을 사용할 때, 세세한 세부 내용까지는 알지 못하지만 사용할 수 있다.
* 스트림 관련 로직을 사용한다고 해서 메서드에 존재하는 작동 로직까지는 다 알지 못한다.
* 물론 알고 있다면 좋겠지만, 그렇게 생각하면 개발에 대한 공부는 20년을 해도 부족하지 않을까...
* 그렇다면 앞에 있는 Portable은 왜 있는걸까

#### Portable Service Abstraction

* 위에서 얘기한 Service Abstraction에서 다른 기술 스택으로 간단하게 변경할 수 있는 확장성이 추가가 되었다고 생각하면 된다.
> PSA = 잘 만든 인터페이스

<hr>

### Spring Example

Spring에서는 Spring Web MVC, Spring Transaction, Spring Cache 등 다양한 PSA를 제공한다.

Cache는 많이 사용해보지 않았지만, Spring으로 개발을 해봤다면 Web MVC와 Transaction은 많이 사용하는 편이라 이해하기 쉽지 않을까 싶다.


#### 1. Spring Web MVC

```java
@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam String name) {
        return "Hello, " + name;
    }
}
```
* Spring Web MVC에서 제공하는 @GetMapping을 사용하여, 개발자는 HttpServletRequest나 HttpServletResponse에 직접 접근하지 않아도 된다.
* 덕분에 다양한 서블릿 컨테이너에 상관없이 일관된 방식으로 웹 요청을 처리할 수 있다.
* @Controller, @GetMapping, @RequestParam, @ResponseBody는 PSA 위에서 동작하며, 우리가 세부로 로직을 모르더라도 활용할 수 있고 실제 구현체에 직접 접근 하지 않아도 웹 요청을 처리할 수 있다.

#### Spring Transaction

```java
@Service
public class MemberService {

    @Transactional
    public void join(Member member) {
        memberRepository.save(member);
        // 예외 발생 시 자동 롤백
    }
}
```
* 트랜잭션이 필요한 메서드에서 @Transactional 어노테이션 하나를 가지고 작업할 수 있다.
* 명시적으로는 commit()과 rollback() 같은 명령어를 활용해야하지만 @Transaction의 PSA 특성을 활용하여 손쉽게 활용할 수 있다.
* 개발자는 @Transactional이 정확하게 어떻게 작동해야하는지 몰라도 된다. (하지만 @Transactional같은 중요한 코드는 정확하게 어떻게 작동하는지 알고 있는게 좋다고 생각합니다.)
* @Transactional은 내부적으로 PlatformTransactionManager를 사용하며, 구현체는 설정에 따라 자동 결정된다.

![transactional_structure.png](..%2Fimage%2FPSA%2Ftransactional_structure.png)

#### 3. Spring Cache

```java
@Service
public class ProductService {

    @Cacheable("products")
    public Product getProductById(Long id) {
        simulateSlowService(); // DB 조회 가정
        return productRepository.findById(id).orElse(null);
    }
}
```

* 여러 캐시 제공자와 무관하게 동일한 방식으로 캐시를 사용할 수 있도록 추상회되어 있다.
* @Cacheable, @CacheEvict 등은 내부적으로 CacheManager를 통해 구현체와 연결되며, 코드 변경 없이 구현체 교체가 가능하다.

<hr>

### 결론

스프링 만든 사람 진짜 대단한 것 같다. 

PSA 기술 덕분에 코드는 더 견고해지고 어떤 상황에서도 유연하게 대처할 수 있다.

내일은 POJO에 관해서 다뤄보자


<hr>


### 참고

```text
https://velog.io/@bernard/Spring-PSA
https://dev-coco.tistory.com/83
https://byeong9935.tistory.com/124
```