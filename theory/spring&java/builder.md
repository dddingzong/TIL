### 빌더와 생성자의 차이

빌더 코드를 몇번 보긴 했지만 지금까지 사용했던 생성자 기법이 편해 항상 생성자를 고집했었다.
요즘 보이는 코드들은 대부분 빌더 패턴을 사용하고 있다.
이번 기회에 빌더를 공부하고 적용해보도록 하자.

모두 객체를 생성하는 방식이지만, 기능적인 부분에서 차이가 난다고 한다.

#### 생성자 패턴

```java
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// 사용 예시
User user = new User("종인", 27);
```

#### 빌더 패턴
```java
@Getter
@Builder
public class User {
    private String name;
    private int age;
}

// 사용 예시
User user = User.builder()
        .name("종인")
        .age(27)
        .build();
```
인자 순서에 구애받지 않고 가독성이 확실히 좋다는 장점이 있다.

객체의 생성에 따라서 유용한 기능이 될 수도 있지만, 변수를 생성하지 않을 시에는 null 값이 들어가기 때문에 주의할 필요가 있다고 생각한다.

무작정 Builder가 맞다고 말하기에는 애매하다고 생각한다.

@Builder.Default를 사용해서 Default 값을 지정할 수 있다.

변수가 적은 간단한 기능에서는 생성자 패턴이 더 직관적이고 간단할 수 있다.

필드 개수가 많거나 객체를 유연하게 생성해야 하는 경우에는 빌더 패턴이 더 유용할 수 있다.

이론상을 봤을때는 솔직히 생성자랑 별 차이를 못느끼겠다 가독성이 좋다 정도? 다음 프로젝트에서 사용하고 직접 느껴봐야 할 것 같다.

테스트 코드에서 객체를 생성할 때에는 유용할 것으로 보인다. 자바에서 엔티티 생성자에 대해서는 엄격하게 관리해야한다는 생각이 들어선지 이거 써도 되나? 싶은 의문이 든다

