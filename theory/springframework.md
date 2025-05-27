## Spring Framework

<hr>

### 서론

거의 3년 동안 Spring Framework를 사용해왔고 분명 초기에 Spring에 관해 공부를 했었다. 김영한님 강의를 들으면서 필기하고 분명 이해했었는데... 

지금 물어보면 대답을 못한다. 애초에 뭐가 있었는지도 기억 안난다. 그래도 spring 그렇게 오래 썼으면 알고 있는게 맞다고 생각한다. 이 기회에 다시 한번 상기시켜보자

Spring 특집은 며칠에 나눠서 진행할 예정이다. 좀 많아서...

오늘은 전체적인 윤곽만 다뤄보자. 내일부터 특징을 하나하나 뜯어볼 예정이다. 기본은 중요하니까...

<hr>

###  Spring Framework?
![springLogo.png](..%2Fimage%2FspringFramework%2FspringLogo.png)

> 자바 엔터프라이즈급 애플리케이션 개발에 사용되는 오픈소스 경량급 애플리케이션 프레임워크이다.
* 엔터프라이즈급 개발이란?: 기업을 대상으로 하는 개발, 즉 대규모 처리가 가능하다.

<hr>

### Spring 이란?

스프링은 스프링 컨테이너라고 불리는 스프링 런타임 엔진을 제공한다. 설정 정보를 참고해서 애플리케이션을 구성하는 오브젝트를 생성하고 관리한다. 보통 웹 모듈에서 동작하는 서비스나 서블릿으로 등록해서 사용한다.

스프링을 사용하다보면 스프링 빈에 등록한다. 도메인은 @Entity 서비스는 @Service 이렇게 등록하는데 해당 내용이 스프링 컨테이너에 저장되는걸로 알고있다. 자세한 내용은 하루하루 공부하며 진행해보자

<hr>

### Spring Framework의 특징
![springFeature.png](..%2Fimage%2FspringFramework%2FspringFeature.png)
> * IoC (Inversion of Control): 제어의 역행
> * DI (Dependency Injection): 의존성 주입
> * AOP (Aspect Oriented Programming): 관점 지향 프로그래밍
> * PSA (Portable Service Abstraction): 추상화 
> * POJO (Plane Old Java Object): 순수 자바 객체


<hr>

### Spring Framework 구조
![springFrameworkStructure.png](..%2Fimage%2FspringFramework%2FspringFrameworkStructure.png)
> * Spring Core
> * Spring Context
> * Spring AOP
> * Spring DAO
> * Spring ORM
> * Spring Web
> * Spring MVC


<hr>

### 결론
내일부터 하나씩 정리해보자. 마무리되면 MVC 모델 진행하고 java의 객체지향 특징도 정리할 예정이다.