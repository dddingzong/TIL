## IoC(Inversion of Control)란?

<hr>

### Inversion of Control: 제어의 역전
* 객체의 생성, 생명주기의 관리까지 객체에 대한 모든 제어권이 외부(스프링 컨테이너)로 바뀌었다는 것

* 컴포넌트 의존관계 설정, 설정, 생명주기를 해결하기 위한 디자인 패턴이다.

<hr>

### IoC Container (=Spring Container)
* IoC 원칙을 구현하는 주체, 객체의 생성과 생명주기 관리, 의존성 주입 등을 관리한다.
* Spring Container라고도 하며, Spring에서는 이 컨테이너가 Bean을 관리한다.
> * IoC 컨테이너는 객체의 생성을 책임지고, 의존성을 관리한다.
> * POJO의 생성, 초기화, 서비스, 소멸에 대한 권한을 가진다.
> * 개발자들이 직접 POJO를 생성할 수 있지만 컨테이너에게 맡긴다

<hr>

### IoC의 분류

![DIAndDL.png](..%2Fimage%2FIoC%2FDIAndDL.png)

> **1. DI (Dependency Injection): 의존성 주입**
> * 객체가 의존하는 다른 객체를 외부에서 주입하는 방식
> * 사용자는 객체를 직접 생성하거나 검색하지 않고, 필요한 의존성은 컨테이너가 자동으로 제공한다
> * 대표적인 방식
>   * 생성자 주입
>   * 새터 주입 (@Setter)
>   * 필드 주입 (@Autowired)

#### DI Example
```java
@Component
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
```

> **2. DL (Dependency Lookup): 의존성 조회**
> * 필요할 때 직접 컨테이너에서 객체를 조회해서 사용하는 방식
> * 잘 사용하지 않는다.

#### DL Example
```java
ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
UserService userService = context.getBean(UserService.class);
```

* 내일은 DI,DL에 관해서 다뤄야겠다

<hr>

### Spring 컨테이너

> * Spring 컨테이너가 관리하는 객체를 빈(bean)이라고 하고, 이 빈을 관리하는 컨테이너를 빈 팩토리(BeanFactory)라고한다.
>   * 객체의 생성과 객체 사이의 런타임 관계를 DI 관점에서 볼 때는 컨테이너를 BeanFactory 라고한다.
>   * BeanFactory에서 여러 가지 기능이 추가되면 애플리케이션 컨텍스(ApplicationContext)라고 한다.

#### BeanFactory
* 가장 기본적인 IoC 컨테이너
* Bean을 등록, 생성, 조회, 반환 관리한다.
* Lazy Loading 방식으로 작동한다.
* 잘 사용되지 않는다. 주로 ApplicationContext를 사용한다.

#### ApplicationContext
* BeanFactory를 확장한 IoC 컨테이너이다.
* Eager Loading 방식으로 작동한다.
* BeanFactory보다 더 추가적으로 제공하는 기능
    * 국제화가 지원되는 텍스트 메시지 관리
    * 이미지와 같은 파일 자원을 로드할 수 있는 방법 제공
    * 리스너로 등록된 빈에게 이벤트 발생 알림

![BeanFactoryAndApplicationContext.png](..%2Fimage%2FIoC%2FBeanFactoryAndApplicationContext.png)


