## TDD

<hr>

### 서론

이번 프로젝트를 TDD로 진행하면서 느낀 점은 생각보다 훨씬 어렵다는 점이다.

기본적으로 어떻게 흘러가는지와 방법은 알겠는데 세부적인 내용을 몰라서 버벅이는 느낌이다.

공부를 진행하기에 앞서 세부적인 내용을 짚고 넘어가고자 이번 TIL을 준비했다.

내가 궁금했던 내용 위주로 공부할거라 내용의 두서가 없을 수도 있다.

<hr>

### 본론

#### 단위 테스트를 작성해야하는 이유

> * 코드를 수정하거나 기능을 추가할 때, 수시로 빠르게 검증할 수 있다.
> * 리펙토링 시에 안전성을 확보할 수 있다.
> * 개발 및 테스킹에 대한 시간과 비용을 절약할 수 있다.

**그러면 모든 TDD는 무조건적으로 단위 테스트로 이루어지는가?**

-> 아니다 주로 단위 테스트로 이루어지긴 하지만 통합 테스트로도 가능하다.

-> TDD는 그냥 개발 방법론이다.

<hr>

#### 좋은 단위 테스트의 특징
> 1. Fast: 테스트는 빠르게 동작하여, 자주 돌릴 수 있어야 한다.
> 2. Independent: 각각의 테스트는 독립적이며, 서로 의존해서는 안된다.
> 3. Repeatable: 어느 환경에서도 반복 가능해야한다.
> 4. Self-Validating: 테스트는 성공 및 실패로 bool 값을 결과로 내어 자체적으로 검증되어야 한다.
> 5. Timely: 테스트는 적시에 즉, 테스트하려는 실제 코드를 구현하기 직전에 구현해야한다.

<hr>

#### 어노테이션 및 변수 정리 

* @ExtendWith(MockitoExtension.class): Junit5와 Mockito를 연결
* @Mock: 가까 객체 생성
* @Spy: Stub 하지 않은 메소드들은 원본 메서드 그대로 사용하는 어노테이션
* @InjectMock: @Mock 또는 @Spy로 생성된 가짜 객체를 자동으로 주입시켜주는 어노테이션
* MockMvc: HTTP 호출을 위해 사용
* @WebMvcTest: 컨트롤러 테스트틀 위한 어노테이션
    * MockMvc 객체가 자동을 생성된다.
    * @Mock과 @Spy 대신 @MockBean과 @SpyBean을 사용한다.
    * 그러면 @ExtendWith(MockitoExtension.class)이랑 동시에 사용 못하는건가
* verify: 가짜 객체의 특정 메서드 호출 횟수 검증

<hr>

### 결론

가장 중요했던 부분인 annotation을 정리할 수 있었어서 좋았다.

아직은 많이 부족하지만 TDD에 있어서 가장 중요한 부분은 그냥 많이 해보는 경험이라고 생각한다.

열심히해야지...

<hr>

### 참고

```text
https://mangkyu.tistory.com/182
https://mangkyu.tistory.com/183
https://mangkyu.tistory.com/184
https://mangkyu.tistory.com/145?category=761302
```
