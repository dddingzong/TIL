## Docker 강의 정리 #1

### 서론
Docker 인프런 강의 들으면서 모르는 내용 혹은 중요한 개념 정리

### 본론

Docker 사용 이유: 이식성
-> 항상 일관된 프로그램 및 버전을 제공한다.
-> 독립적인 환경에서 작동하기 때문에 다른 프로그램과 충돌이 나지 않는다.

Docker: 컨테이너를 사용하여 각각의 프로그램을 분리된 환경에서 실행 및 관리할 수 있는 툴

Container: 하나의 컴퓨터 환경 내에서 독립적인 컴퓨터 환경을 구성해서, 각 환경에 프로그램을 별도로 설치할 수 있게 만든 개념 (컴퓨터 속 미니 컴퓨터)

![](https://velog.velcdn.com/images/dddingzong/post/5de3d6bf-e576-43c0-a530-c54be75cc6e5/image.png)

호스트 컴퓨터: 컨테이너를 포함하고 있는 컴퓨터


#### 컨테이너의 독립성

* 저장 공간: 각 컨테이너마다 각자의 저장 공간을 가지고 있다. 다른 컨테이너에 있는 파일에 접근이 불가능하다.
* 네트워크: 각 컨테이너마다 고유의 네트워크를 가지고있다. 고유의 IP와 PORT를 가진다.


이미지: 닌텐도의 칩에 비유

![](https://velog.velcdn.com/images/dddingzong/post/8fc422c7-4f4b-4209-bbce-b9780b359606/image.png)


<hr>

```
docker pull nginx
```
이런식으로 작성하는 이미지 다운로드는 docker hub에서 가져오게 된다.

tag: 이미지 버전


이미지 조회
```
docker image ls
```

이미지 삭제
```
docker image rm <IMAGE ID>
```

이미지 강제 삭제
```
docker image rm -f <IMAGE ID>
```
* 중단된 이미지가 있더라도 삭제
* 실행중인 이미지는 삭제 불가


컨테이너에서 사용하지 않는 전체 이미지 삭제

```
docker image rm $(docker images -q)
```

컨테이너 생성 명령어
```
docker create nginx
```
* image가 없다면 자동으로 다운로드


컨테이너 시작 명령어
```
docker start <IMAGE ID>
```

컨테이너 생성 + 시작 명령어
```
docker run nginx
```
* foreground: 내가 실행시킨 프로그램의 내용이 화면에서 실행되고 출력되는 상태
* background: 내가 실행시킨 프로그램이 컴퓨터 내부적으로 실행되는 상태


컨테이너 Run + 이름 지정
```
docker run -d --name my-web-server nginx
```

![](https://velog.velcdn.com/images/dddingzong/post/94cfa763-7f7d-4d93-9359-d01242e97abd/image.png)


<hr>

실행중인 컨테이너 조회
```
docker ps
```

모든 컨테이너 조회
```
docker ps -a
```

컨테이너 종료
```
docker stop <CONTAINER ID> - 깔끔하게 종료
docker kill <CONTAINER ID> - 강제종료
```

컨테이너 삭제
```
docker rm <CONTAINER ID>
```
* 실행되고 있는 컨테이너는 삭제 불가


중지되어 있는 모든 컨테이너 삭제
```
docker rm $(docker ps -qa)
```

<hr>

#### 로그 조회

컨테이너 로그 조회
```
docker logs <CONTAINER ID>
```

옵션
* --tail 10:
* -f: 실시간 확인

<hr>

#### 실행중인 컨테이너 내부에 접속하기
컨테이너 내부 접속
```
docker exec -it <CONTAINER ID> bash
```





