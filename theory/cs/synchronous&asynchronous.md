## 동기 / 비동기 & blocking / non-blocking

### 서론
<hr>

개발을 진행하면서 API를 처리하다보면 한번쯤은 볼 수 있는 용어다.

처음에는 그냥 동기는 순서대로 처리하고 비동기는 동시에 처리한다라고만 생각했다.
그러면 비동기가 동기보다 안좋은 이유는 뭐지? 빠른게 좋은거 아닌가? 라고도 생각했다.

TIL를 기회로 해당 개념을 제대로 잡아보도록 하자. 동기, 비동기와 같이 항상 언급되는 것이
blocking과 non-blocking이다. 공부하는김에 두가지 개념도 같이 정리하자.

<hr>

### 동기 / 비동기

![동기_비동기.png](..%2Fimage%2Fsynchronous%26asynchronous%2F%EB%8F%99%EA%B8%B0_%EB%B9%84%EB%8F%99%EA%B8%B0.png)

#### 동기

* Process A가 작업을 시작시키고, Process B 작업이 끝나야지 A가 다시 작동한다.
* 작업 요청을 했을 시에, 요청의 결과값을 직접 받는다.
* 요청의 결과값이 return 값과 동일하다.
* **호출한 함수가 작업 완료를 확인한다.**


#### 비동기
* Process A가 작업을 시작시키고, Process B를 기다리지 않고 A가 작동한다.
* 작업 요청을 했을 시에, 요청의 결과값을 간접적으로 받는다.
* 요청의 결과값이 return 값과 다르다.
* **호출된 함수(callback 함수)가 작업 완료를 확인한다.**

<hr>

### blocking / non-blocking

![blocking_non-blocking.png](..%2Fimage%2Fsynchronous%26asynchronous%2Fblocking_non-blocking.png)

#### 제어권의 관점에서 생각하면 쉽다.


#### blocking
* 요청한 작업을 마칠때까지 대기한다.
* return 값을 받아야 끝난다.
* 호출된 함수가 제어권을 넘겨주지 않는다.

#### non-blocking
* 요청한 작업을 즉시 마치지 못하면 즉시 return 한다.
* 호출된 함수가 즉시 제어권을 넘겨준다.
* 호출한 함수는 호출된 함수가 모든 작업을 끝낼때까지 기다리지않고 다음 작업을 수행한다.

<hr>

### 동기 / 비동기 & blocking / non-blocking의 차이는?

#### 동기 비동기
> 호출되는 함수의 작업 완료 여부를 누가 신경쓰는가?
> 
#### blocking non-blocking
> 호출되는 함수가 바로 return을 하는가?

<hr>

### 동기 / 비동기 & blocking / non-blocking의 조합

![동기_비동기_blocking_non-blocking.png](..%2Fimage%2Fsynchronous%26asynchronous%2F%EB%8F%99%EA%B8%B0_%EB%B9%84%EB%8F%99%EA%B8%B0_blocking_non-blocking.png)

#### 1. 동기 + blocking
* 요청한 작업이 완료될 때까지 기다리며, 순차적으로 처리된다.
* 가장 흔한 방식이다.
* ex) Spring MVC, JDBC

#### 2. 동기 + non-blocking
* 요청한 작업이 즉시 반환되지만, 응답 확인을 처리해야한다.
* 기다리지는 않지만 요청 - 응답을 순차적으로 관리한다.
* java nio

#### 3. 비동기 + blocking
* 요청은 비동기적으로 처리되지만 결과를 기다릴때는 블로킹된다.
* ex) async/await

#### 4. 비동기 + non-blocking
* 작업을 요청하고 결과가 도착하면 콜백 상황을 알려주며 기다리지 않는다.
* 가장 효율적이지만 구현 복잡도가 높다. (현대적인 고성능 방식)
* ex) node.js






