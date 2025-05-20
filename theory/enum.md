## Enum은 왜 사용하는걸까?

<hr>

### 서론
개발을 진행하면서 사용하던 기술만 쓰다보면 안쓰게 되는 기술은 계속해서 안쓰게 되는 것 같다.

그래서 기존에 배웠었지만 정작 사용하려면 처음부터 다시 공부해야하는 불편함이 존재하는데
그 기술 중 하나가 Enum이다.

고수분들의 코드를 보면 가끔 찾아볼 수 있는데 저는 사용한 적이 거의 없는 것 같다.

이번 기회에 다시 한번 학습해 프로젝트에서도 녹여낼 수 있도록 노력해야겠다.

<hr>

enum은 자바를 처음 공부할 때 봤어서 어렴풋이 기억은 난다.

enum이 뭔지부터 짚고 넘어가자. 

### Enum이란?

> **미리 정의된 상수들의 특별한 집합**

말 그대로 상수들을 열거(enumeration)한 집합이다.

상수이기 때문에 당연히 불변이고 항목은 대문자로 작성한다.

그렇다면 enum은 왜 사용하는걸까 장점을 알아보자
<hr>

### enum의 장점

> 1. 문자열과 비교하여 IDE의 적극적인 지원을 받을 수 있다.
> 
>  - 자동완성, 오타검증, 텍스트 리펙토링 등
> 
> 2. 허용 가능한 값들을 제한할 수 있다.
> 3. 리펙토링시 변경 범위가 최소화 된다.
> 
>  - 내용의 추가가 필요하더라도, enum 코드 외에 수정할 필요가 없다.

사실 이것 외에 가장 좋다고 생각하는 기능은 **클래스**로써 작동한다는 부분인 것 같다.

이 글을 누가 볼지는 모르겠지만 자세한 사항은 이동욱님의 우아한 기술 블로그를 참조하시면 될 것 같습니다. 엄청나게 잘 정리하셨어요.

> [우아한 기술 블로그 (Enum) - 이동욱](https://techblog.woowahan.com/2527/)

이 글도 해당 게시물을 읽고 작성했습니다. 퀄리티는 많이 떨어지지만;;

여기서는 기본적인 사용 방법만 알아두도록 하자

내 코드에서 enum을 딱 한번 사용했는데 해당 예시를 통해서 살펴보자
<hr>

### Example

PayCheck.java
``` java
public enum PayCheck {
    FALSE, TRUE, ISSUE;
}
```

EnumMain.java
```java
public class EnumMain {
    public static void main(String[] args) {
        enumExample(PayCheck.TRUE);
        enumExample(PayCheck.FALSE);
        enumExample(PayCheck.ISSUE);
    }

    private static void enumExample(PayCheck payCheck) {
        if (payCheck == PayCheck.TRUE){
            System.out.println("정산 완료 사용자 입니다.");
        }

        if (payCheck == PayCheck.FALSE){
            System.out.println("정산 미완료 사용자 입니다.");
        }

        if (payCheck == PayCheck.ISSUE){
            System.out.println("연체 금액 보유 사용자 입니다.");
        }
    }
}

```
결제 관련 기능을 구현하는 도중 유저의 상태를 분류하기 위해 enum을 사용했다. 
정말 간단하게 사용해서, 사실 이 정도면 enum 기능의 5% 정도 사용한 것 같다.

이대로 끝내면 아쉬우니 조금 더 알아보자

<hr>

### 추가

Java에서 enum은 내부적으로 클래스처럼 동작하므로, 다음과 같은 기능을 가질 수 있다.
> * 필드(멤버 변수)
> * 생성자
> * 메서드


### Example

```java
public enum PayCheck {
    TRUE("정산 완료"),
    FALSE("정산 미완료"),
    ISSUE("연체 금액 보유");

    private final String description; // 필드 추가

    // 생성자 추가
    PayCheck(String description) {
        this.description = description;
    }

    // 메서드 구현
    public String getDescription() {
        return description;
    }
}

```

```java
public class EnumMain {
    public static void main(String[] args) {
        PayCheck check = PayCheck.TRUE;

        // 메서드 호출을 통해 설명 출력
        System.out.println("현재 상태: " + check.getDescription());
    }
}

```
사실 이정도는 해줘야지 enum을 사용했다 라고 할 수 있다. 
위에서는 enum이 클래스라는 사실을 아예 사용하지 못했기 때문에,
그냥 List를 사용한거와 다를 바가 없다.

더 공부해서 프로젝트에서 enum을 100% 사용할 수 있기를 바라며 TIL 끝!