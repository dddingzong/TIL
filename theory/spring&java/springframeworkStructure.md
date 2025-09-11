## Spring Framework Structure

<hr>

### 스프링 프레임 워크 구조

![springFrameworkStructure.png](..%2Fimage%2FspringframeworkStructure%2FspringFrameworkStructure.png)

* Spring Framework는 계층적이고 모듈화된 구조를 가지고 있으며, 각각의 구성 요소는 독립적으로 또는 조합하여 사용할 수 있다.

<hr>

#### 1. Servlet Core
* Spring Container를 의미한다.
* container는 spring framework의 핵심이며, 그 중 Bean Factory Container가 가장 중요하다.
* 객체의 생성, 초기화, 소멸 등의 생명주기를 관리한다.
* Bean Factory는  IOC 패턴을 적용하여 객체 구성부터 의존성 처리까지 모든일을 처리한다.

#### 2. Spring Context
* Spring Framework의 context 정보들을 제공하는 설정 파일
* spring context에는 JNDI, EJB, Validation, Scheduling 등 엔터프라이즈 서비스들이 포함되어 있다. 


#### 3. Spring AOP
* Spring Framework에서 관점지향 프로그래밍을 할 수 있고, AOP를 적용할 수 있게 도와주는 Module

#### 4. Spring DAO
* Data Access Object의 약자로 Database에 접근하기 위한 객체
* 추상 레이어를 지원하며, 코딩이나 예외처리하는 부분을 간편화시켜 일관된 방법으로 코드를 짤 수 있게 도와줌

#### 5. Spring ORM
* Object relational mapping의 약자로, 간단히 객체와의 관계 설정을 하는 것
* Spring에서는 ibatis, Hibernate, JDO 등 객체 관계형 도구를 사용할 수 있도록 지원한다.

#### 6. Spring Web
* Spring에서 Web context module은 Application module에 내장되어 있으며, Web 기반의 응용 프로그램에 대한 context를 제공하여 일반적인 Web Application 개발에 필요한 기본적인 기능을 지원

#### 7. Spring MVC 
* model2 구조로 Application을 만들 수 있도록 지원. MVC 프레임워크는 웹 응용 프로그램을 작성하기 위한 완전한 기능을 갖춘 MVC를 구현한다.






















