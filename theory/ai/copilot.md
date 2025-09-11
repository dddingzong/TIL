## Copilot은 왜 사용하는 걸까?

<hr>

### 서론

요즘 Chatgpt와 같은 생성형 AI의 도움 없이 뭔가를 진행한적이 없는 것 같다. 

프로젝트와 문서 작성은 둘째치고, 간단한 자료조사나 그냥 일상적인 용도로도 자주 사용하는 것 같다. 

개발하는 사람들이라면 한번쯤 들어봤을 Copilot,
한번도 사용해본 적이 없는데 TIL를 진행하면서 시도해보고자 한다.

<hr>

### 진행

가장 대중적으로 사용하는 Gibhub Copilot으로 진행해보자.

![img.png](../image/copilot/copilot_plan.png)

일단 Free로 진행할 예정이다, 
유용하다면 유료 서비스를 이용할 생각도 있으나 
아직까지는 결제 하에 Copilot 보다 Chatgpt가 더 유용하다는 의견이 많은 것 같다.

무료 서비스에서 제공하는 기능은
* 한 달에 자동화 작업 50회
* 한 달에 프롬프트 자동화 2000회
* Claude 3.5 Sonnet, GPT-4.1 등 언어 모델 사용 가능

무료에서는 GPT-4.1이지만 Pro+ 에서는 4.5까지 제공한다. 개발자로 취적한다면 큰맘 먹고 1년 정도 결제해서 사용해보고 싶다.

### 설치

![img.png](../image/copilot/copilot_plugin.png)

설치는 그냥 intellij plugin에서 설치하면 된다.

<hr>

### Example

![img.png](../image/copilot/copilot_code_example.png)

CopilotMain 클래스 생성 후 간단하게 market 로직을 구현하려고 했는데 저렇게 예시를 준다.

간단한 로직이긴 하지만 짜임새가 훌륭하다고 생각한다.

이정도면 실제 간단한 로직 구현에서 많은 도움을 받을 수 있을 것 같다.

Tab을 눌러서 예제 코드를 활성화 할 수 있고. (ALT+[) , (AlT+]) 를 통해서 예시를 바꿀 수 있다.

그리고 상당히 신기했는데

![img.png](../image/copilot/copilot_md_example.png)

이렇게 markdown에서도 추천 글귀를 달아준다. 사실 기대 안했는데 굉장히 유용한것 같다.

<hr>

### 자동화 작업

코드 추천 말고도 질문 형식으로 자동화 작업을 할 수 있다.

![img.png](../image/copilot/copilot_question.png)


MarketService.java
 ```java

package copilotExample;

import java.util.HashMap;
import java.util.Map;

public class MarketService {
    private Map<String, Integer> products = new HashMap<>();

    public MarketService() {
        products.put("Apple", 10);
        products.put("Banana", 5);
        products.put("Orange", 8);
    }

    public void listProducts() {
        System.out.println("Available products:");
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " left");
        }
    }

    public boolean buyProduct(String name, int quantity) {
        if (!products.containsKey(name)) {
            System.out.println("Product not found.");
            return false;
        }
        int stock = products.get(name);
        if (stock < quantity) {
            System.out.println("Not enough stock.");
            return false;
        }
        products.put(name, stock - quantity);
        System.out.println("Bought " + quantity + " " + name + "(s).");
        return true;
    }
}
```

CopilotMain.java
```java
package copilotExample;

public class CopilotMain {
    public static void main(String[] args) {
        MarketService market = new MarketService();
        market.listProducts();
        market.buyProduct("Apple", 2);
        market.listProducts();
    }
}
```
생각보다 똑똑한 것 같다. chatgpt한테 딱히 밀린다는 생각이 안든다. 
근데 사실 Chatgpt 기반으로 만든 프로그램이라서 안밀리는게 당연하긴하다.

그냥 IDE에서 사용하기 편하고 개발 친화적이다 정도? 

프롬프트 창에서 '/'를 입력하면 여러 커맨드 목록을 확인할 수 있다.

![img_1.png](../image/copilot_command/img_1.png)

코드 설명이나 피드백, 리펙토링 등을 수행할 수 있다.

<hr>

### 결론

자세하게 다루지는 않았지만 상당히 유용하다고 생각이 든다.
나중에 더 깊게 공부해서 velog에 따로 올려야겠다.

충분한 공부를 통해 활용성을 높여 진입해야할 것 같다.

근데 사실 나는 이런 자동화 툴을 딱히 좋아하진 않는다.
이런 기능에 너무 의존하게 되면 코드 구현 능력이 떨어질 것 같아서
개발 시에는 Chatgpt 사용을 최소화하는 편이다.

그냥 간단한 업무 정도는 돕는 식으로 
개발 연차가 좀 쌓이면 하는게 좋을 것 같다.

하지만 코드 리펙토링이나 피드백같은 커멘드는 유용하게 사용할 것 같다.
개발을 진행하면서 중요하다고 생각하는 요소 중 하나가 코드 리뷰인데
번거로운 과정없이 보급형 코드 리뷰를 진행할 수 있다는 점은 
유용한 기능이라고 생각한다.