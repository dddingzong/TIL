# TIL (Today I Learned)

<img src="https://github.com/user-attachments/assets/9c7fed6b-d1a5-4081-af39-079c8c1a8332" width="450px">

이 저장소는 소프트웨어 엔지니어링 학습 내용을 정리하는 개인 TIL 아카이브입니다.  
Spring Framework와 Java를 중심으로, DevOps, CS, 클라우드, AI 도구 활용, 알고리즘 풀이까지 학습 범위를 넓혀가며 기록합니다.

## 목적

- 하루 단위 학습 내용을 꾸준히 남기기
- 이론을 문서로 정리하고 필요한 경우 코드로 직접 확인하기
- 나중에 다시 찾아볼 수 있는 개인 지식 베이스 만들기

## 저장소 구조

### [`theory/`](./theory)
주제별 이론 정리 문서가 들어 있습니다.

- `spring&java/`: Spring, IoC, DI, AOP, TDD, enum, builder 등
- `devOps/`: DevOps 학습 기록
- `aws-saa/`: AWS SAA 관련 정리
- `cs/`, `server&cloud/`, `etc/`, `ai/`: CS, 인프라, 도구, AI 관련 문서

### [`src/main/java/`](./src/main/java)
이론과 연결되는 간단한 Java 예제 코드가 들어 있습니다.

- `enumExample/`: enum 관련 예제
- `org/example/`: 기본 실행 예제

### [`백준/`](./백준)
백준 알고리즘 문제 풀이를 난이도와 주제별로 정리한 공간입니다.

- `Bronze/`, `Silver/`, `Gold/`
- `custom/`: 개별 연습, 학교 예제, 특정 주제 풀이

### [`image/`](./image)
각 문서를 보조하는 다이어그램, 캡처, 시각 자료가 들어 있습니다.

### [`openSource/`](./openSource)
오픈소스를 보며 구조를 분석하거나 코드리뷰 형식으로 정리한 문서가 들어 있습니다.

## 다루는 학습 주제

- Spring Framework
- IoC, DI, AOP, PSA
- Java enum, builder pattern, ControllerAdvice
- TDD, mock 객체
- 동기 / 비동기, blocking / non-blocking
- DevOps, Docker, Reverse Proxy, Infra
- AWS SAA 학습 주제
- Copilot, Claude, MCP 등 AI 도구 활용
- 백준 알고리즘 문제 풀이

## 실행 방법

현재 Gradle 설정은 문서 저장소에 가까운 가벼운 Java 프로젝트 형태입니다.  
예제 코드를 빌드하거나 테스트할 때는 아래 명령을 사용할 수 있습니다.

```bash
./gradlew build
./gradlew test
```

## 이 저장소를 보는 방법

문서를 먼저 보려면 [`theory/`](./theory)부터 시작하는 것이 좋습니다.  
실제 코드 예시는 [`src/main/java/`](./src/main/java)와 [`백준/`](./백준)에 분리되어 있습니다.

## 앞으로 계속 채워갈 내용

- 학습한 이론 문서 추가
- 이론과 연결되는 예제 코드 보강
- 알고리즘 풀이 누적
- 오픈소스 구조 분석 기록 확장
