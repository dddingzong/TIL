## DI(Dependency Injection)이란?

<hr>

### Dependency Injection: 의존 관계 주입
* DI는 외부에서 객체 간의 관계를 결정해 주는데, 객체를 직접 생성하는 것이 아니라 외부에서 생성 후 주입시켜주는 방식이라 할 수 있다.
* DI를 통해 객체 간의 관계를 동적으로 주입하여 유연성을 확보하고 결합도를 낮출 수 있다.


<hr>

### Spring에서 DI 방법
> * Construct Injection (생성자 주입)
> * Field Injection (필드 주입)
> * Setter Injection (Setter 주입)

* Spring 3.x 버전까지는 Setter 주입을 권장했으나, 순환 참조 등의 문제로 인해 Spring 4.3 이후 버전 이후부터는 생성자 주입을 권장하고 있다.

<hr>

### 1. Constructor Injection : 생성자 주입
* 가장 많이 사용하는 방식이다.
* @Autowired가 생략 가능하다
* Lombok 라이브러리의 @RequiredArgumentConstructor와 함께 자주 사용한다
* final 키워드를 사용하기에 객체의 불변성이 보장된다.
* 초기에 할당되기에 Nul Point Exception이 발생하지 않는다.

#### Example
```java
@Component
public class UserService {
    private final UserRepository userRepository;

    @Autowired  // 스프링 4.3 버전 이상에서는 생략 가능
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
```
* 가장 많이 사용하는 기법인데 여기서 @RequiredArgumentConstructor와 자주 사용한다.

```java
@Component
@RequiredArgumentConstructor
public class UserService {
    private final UserRepository userRepository;
}
```
* 해당 형태로 가장 많이 쓴다.
* 개발하다 보면 왜 이 형식으로 쓰는지 자주 까먹는데 오랜만에 알았다.


<hr>

### 2. Field Injection : 필드 주입
* @Autowired 를 사용해서 객체 내 필드에 선언해서 주입하는 방법
* 간편하게 의존 관계 주입이 가능하지만 참조 관계를 눈으로 확인하기 어렵고, 순환 참조를 막을 수 없다.
* 순환 참조: A -> B, B -> A 참조 상황
* 생성자 주입을 뺀 나머지(필드 주입, Setter 주입)는 생성자 이후에 호출되므로, 필드에 final 사용이 불가하다.

#### Example
```java
@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;
}
```
* 불변성이 보장되지 않고 SRP 원칙도 위반한다.
* 사실상 비추천하는 방식인 것 같다.

<hr>

### 3. Setter Injection : Setter 주입
* @Autowired와 Setter 메서드를 활용해 주입하는 방법
* Null Point Exception이 발생할 수 있다.
* 생성자 주입을 뺀 나머지(필드 주입, Setter 주입)는 생성자 이후에 호출되므로, 필드에 final 사용이 불가하다.

#### Example
```java
@Component
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
```
* 선택적 의존성 주입에 적합하지만, 필드가 불완전한 상태로 객체가 생성될 수 있다.

<hr>

### 결론

생성자 주입이 Spring에서 권장하는 방법이기도 하고 가장 안정적인 방식인 것 같다.

게다가 특징 프레임워크에 의존하지 않고 순수 Java에 대한 특징을 잘 살릴 수 있는 방법이다.






