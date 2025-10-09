## Docker 강의 정리 #2

### 컨테이너가 가진 문제점
![](https://velog.velcdn.com/images/dddingzong/post/327609b5-c11e-477e-9884-8e46cca3f7f0/image.png)

### 도커 볼륨이란?
![](https://velog.velcdn.com/images/dddingzong/post/249a043d-e03e-42d4-9470-316a46516ba0/image.png)


### 볼륨 사용 명령어
![](https://velog.velcdn.com/images/dddingzong/post/b9ef8360-718d-4f8f-8fc9-c72c661d9584/image.png)
![](https://velog.velcdn.com/images/dddingzong/post/fe7aa3ee-7066-487b-ac53-90ef6d71fd01/image.png)

### MySQL

![](https://velog.velcdn.com/images/dddingzong/post/05789188-cc64-40c0-abf2-95a32fc6a308/image.png)

* 호스트 컴퓨터에 있는 볼륨의 설정을 바꾸더라도 초기화된 값으로 유지된다.
* ex) 비밀번호를 바꾸더라도 바뀌지 않는다.


* 볼륨을 생성할 시에는 존재하지 않는 디렉토리에서 시작하는 것이 좋다.


### Dockerfile이란?

* dockerfile을 통해서 Docker 이미지를 만들 수 있다.


#### 도커 문법
FROM: 베이스 이미지를 생성하는 역할을 한다. (특정 초기 이미지)
* ex) 미니 컴퓨터 환경을 구축할 때 설치할 기본 프로그램을 선택하는 옵션

자바17 설치
```
FROM openjdk:17-jdk
```

로그가 남지 않고 실행되지 않는 컨테이너를 디버깅 하는 방법

```
ENTRYPOINT ["/bin/bash", "-c", "sleep 500"]
```
* 500초 동안 시스템을 일시정지 시키는 명령어


COPY: 호스트 컴퓨터에 있는 파일을 복사해서 컨테이너로 복사한다.
![](https://velog.velcdn.com/images/dddingzong/post/8536150d-d4db-4e25-ad71-48fb071c1e46/image.png)

app.txt 복사
```
COPY app.txt /app.txt
```
모든 txt파일을 text-files 폴더에 복사
```
COPY *.txt /text-files/
```

dockerignore: 이미지생성시 처리되지 않는 파일


ENTRYPOINT: 컨테이너가 시작할 때 실행되는 명령어

```
ENTRYPOINT ["/bin/bash", "-c", "echo hello"]
```

### Spring Boot 프로젝트를 Docker로 실행시키기

docker에서 간단한 spring 프로젝트 실행
```
FROM openjdk:17-jdk

COPY build/libs/*SNAPSHOT.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
```

RUN: 이미지를 생성하는 과정에서 사용하는 명령문 실행

![](https://velog.velcdn.com/images/dddingzong/post/bb7100e9-dc22-4e47-b2e8-a642817519a4/image.png)

RUN: 이미지 생성 과정에서 필요한 명령어 실행
ENTRYPOINT: 생성된 이미지를 기반으로 컨테이너를 생성한 직후에 명령어를 실행

```
FROM ubuntu

RUN apt update && apt install -y git

ENTRYPOINT ["/bin/bash", "-c", "sleep 500"]
```
* 깃 설치 포함

WORKDIR: 작업 디렉토리를 지정

EXPOSE: 컨테이너 내부에서 사용 중인 포트를 문서화하기
* 그냥 정리용 -> 문서화

![](https://velog.velcdn.com/images/dddingzong/post/3839c876-451a-49ec-8444-e56f17863e58/image.png)


alpine 태그: 필요한 이미지만 남겨둬 최적화된 이미지






