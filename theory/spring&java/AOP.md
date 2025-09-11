## AOP(Aspect Oriented Programming)이란?

<hr>

### Aspect Oriented Programming: 관점 지향 프로그래밍

* AOP 관련 코드는 실전에서 많이 사용한 적이 없는 것 같다. 이번 기회에 잘 적용시켜 보자.
* 어떤 로직을 기준으로 핵심적인 관점, 부가적인 관점으로 나누어서 보고 그 관점을 기준으로 각각 모듈화한다.
* 핵심 관심사와 횡단 관심사를 분리하여 가독성과 모듈성을 향상시킨다.
> * 핵심 관심사: Core Concerns (핵심 기능)
> * 횡단 관심사: Cross-cutting Concerns (부가 기능)


<hr>

### AOP 사용 목적

* 핵심 코드와 공통(서브) 코드를 분리하여, 코드 중복을 줄이고 유지보수성을 높인다.
* AOP를 활용하면 한 곳에서 공통 기능을 처리할 수 있어 수정과 확장이 편리하다.
> * 서브 코드의 종류: 로깅, 트랜잭션, 보안, 캐싱


<hr>

### AOP의 주요 개념

#### Aspect
* 횡단 관심사(공통 기능)를 정의한 클래스
* @Aspect 어노테이션으로 선언
* Advice와 Pointcut을 조합하여 구성된다.
* 핵심 로직 외에 부가 기능(로깅 등)을 담당하는 모듈

#### Advice
* 횡단 관심사를 구현한 실제 구현체를 의미한다.
* 언제 실행할지에 따라 여러 종류가 존재한다.

> * @Before: 메서드 실행 전
> * @After: 메서드 실행 후 (예외 관계없이)
> * @AfterReturning: 메서드 정상 종료 후
> * @AfterThrowing: 예외 발생 시
> * @Around: 전후 모두 감싸서 실행 흐름 제어

#### JoinPoint
* Advice가 적용 가능한 지점 (주로 메서드 호출 시점)
* 특정 대상에서(메서드) 횡단 로직(Advice)이 수행될 시점을 의미한다.

#### Pointcut
* 어떤 JoinPoint에 Advice를 적용할지 결정한다.
* 표현식을 표현하며 대표적으로 execution이 있다.
* excution({접근 제어자} /{패키지 이름}.{클래스 이름}.{메소드 이름({매개변수})})

#### Weaving
* Advice를 주기능에 적용하는 행위
* 프록시 생성 시 실행된다.

<hr>

### AOP 예시

#### 1. 로깅
```java
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example..*Service.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("메서드 시작: {}", joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "execution(* com.example..*Service.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("메서드 종료: {}, 반환값: {}", joinPoint.getSignature(), result);
    }
}
```
* com.example 패키지 이하의 모든 Service 클래스의 모든 메서드를 대상으로 한다.
* @Before을 활용해서 메서드 실행 전에 로그 출력
* @AfterReturning은 정상적으로 메서드 실행 후 반환값과 함께 로그 출력



#### 2. 트랜잭션 관리
```java
@Service
public class OrderService {

    @Transactional
    public void placeOrder(OrderRequest request) {
        orderRepository.save(request.toOrder());
        paymentService.charge(request.getPaymentInfo());
    }
}
```
* @Transactional 은 Spring의 AOP로 구현되어 있다.
* 내부적으로 AOP 프록시가 메서드 실행 전후에 프랜잭션 처리를 자동 적용


#### 3. 보안 검사
```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AdminOnly {}
```
```java
@Aspect
@Component
public class SecurityAspect {

    @Before("@annotation(com.example.annotation.AdminOnly)")
    public void checkAdmin() {
        if (!UserContextHolder.getCurrentUser().isAdmin()) {
            throw new AccessDeniedException("관리자 권한이 필요합니다.");
        }
    }
}

```
```java
@AdminOnly
public void deleteUser(Long userId) {
    userRepository.deleteById(userId);
}

```
* 커스텀 어노테이션을 활용하여 특정 메서드에만 보안 검사를 적용
* 일반 사용자 접근시 AccessDeniedException이 발생한다
* 해당 내용은 이후 관리자 기능 구현 시에 도움이 많이 될 것 같다.

#### 4. 캐싱
```java
@Aspect
@Component
@RequiredArgsConstructor
public class CacheAspect {

    private final Map<String, Object> cache = new ConcurrentHashMap<>();

    @Around("execution(* com.example.service.ProductService.getProduct(..))")
    public Object applyCache(ProceedingJoinPoint pjp) throws Throwable {
        String key = Arrays.toString(pjp.getArgs());

        if (cache.containsKey(key)) {
            log.info("캐시에서 데이터 반환: {}", key);
            return cache.get(key);
        }

        Object result = pjp.proceed();
        cache.put(key, result);
        return result;
    }
}
```
* @Around를 활용하여 메서드 실행 전후에 작동한다.
* 기존에 호출한 적이 있다면, 캐시된 값을 반환하고, 그렇지 않으면 메서드 실행 후 결과를 캐시에 저장한다.

#### 5. 예외 처리
```java
@Aspect
@Component
public class ExceptionAspect {

    @AfterThrowing(pointcut = "execution(* com.example..*Service.*(..))", throwing = "ex")
    public void handleException(JoinPoint jp, Throwable ex) {
        log.error("예외 발생: {} - {}", jp.getSignature(), ex.getMessage());
        // 필요시 알림 전송, 에러 로그 DB 저장 등
    }
}

```
* 예외가 발생했을 때만 동작하는 AOP이다.
* @AfterThrowing은 예외 정보를 받아서 로그를 출력한다.
* 예외를 직접 처리하거나 가로채지는 않는 로그와 후처리용이다.


#### 6. 성능 모니터링
```java
@Aspect
@Component
public class PerformanceAspect {

    @Around("execution(* com.example..*Service.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        log.info("실행 시간 [{}]: {}ms", pjp.getSignature(), (end - start));
        return result;
    }
}
```
* @Around를 활용하여 메서드 실행 전후에 작동한다.
* 성능 파악, 특정 기능의 실행 시간 추적 등 성능 최적화 부분에서 사용할 수 있을 것 같다.

<hr>

### AOP 적용 방식

#### 1. 컴파일 타임 방식
* AOP가 코드를 컴파일할 때 적용되는 방식
* AspectJ 같은 AOP 프레임워크를 사용해, 컴파일 시점에 Aspect가 바이트코드에 삽입된다.
> * 장점: 가장 강력하고 정교한 AOP 구현 가능
> * 단점: 코드 변경 시마다 반드시 다시 컴파일 해야한다.

#### 2. 로그 타임 방식
* 클래스가 JVM에 의해 로드되는 시점에 AOP가 적용되는 방식
* 클래스 로더가 바이트 코드를 읽어 들이면서 Aspect를 삽입한다.
> * 장점: 컴파일 이후로도 바이트코드를 수정하지 않고 AOP 적용 가능
> * 단점: JVM 클래스 로더 설정에 의존적이고, 환경에 따라 복잡할 수 있음

#### 3. 런타임 방식
* Spring AOP와 같은 프록시 기반 프레임워크에서 주로 사용한다.
* 애플리케이션 실행 중 프록시 객체를 생성하며 Aspect를 동적으로 적용한다
> * 장점: 설정이 쉽고 동적인 AOP 구현 가능
> * 단점: 프록시 생성으로 인한 약간의 런타임 오버헤드 발생 가능성 존재


<hr>

### 결론
공부하면서 느낌점은 충분히 실제 서비스에 적용할만한 기능이다.

지금까지 프로젝트를 진행하면서 하나하나 작성하면서 진행했는데,
이제는 자바와 스프링의 장점을 살릴 수 있는 개발자로 성장하고싶다.

