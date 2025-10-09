## Docker 강의 정리 #3

### Docker Compose
* 여러 개의 Docker 컨테이너들을 하나의 서비스로 정의하고 하나의 묶음으로 관리할 수 있게 도와주는 툴

1. 여러개의 컨테이너를 관리하는데 용이
2. 복잡한 명령어 간소화

```
#docker run --name web-server -p 80:80 nginx

services: # 하나의 컨테이너
  my-web-server: # 서비스 이름
    container_name: web-server # 컨테이너 이름
    image: nginx # 이미지 기반
    ports:
      - 80:80
```
* 두 명령어는 같다

### docker compose 명령어 정리

compose 실행
```
docker compose up (-d)
```

compose 종료
```
docker compose down
```

실행되고 있는 compose 확인
```
docker compose ps
```

compose 로그 확인
```
docker compose logs  
```

이미지를 업데이트
```
docker compose pull
```

### docker compose로 redis 실행
```
services:
  my-cache-server:
    image: redis
    ports:
      - 6379:6379
```


### docker compos로 mysql 실행
```
services:
  my-db:
    image: mysql
    environment:
      MYSQL_ROOT_PASSWORD: pwd1234
    volumes:
      - ./mysql_data:/var/lib/mysql
    ports:
      - 3306:3306
```

### docker compos로 spring boot 실행
```
services:
  my-server:
    build: . #dockerfile의 위치
    ports:
      - 8080:8080
```
build: 이미지에서 build를 새로 해주는 기능
```
docker compose up -d --build
```

### MySQL, Redis 컨테이너 동시에 띄워보기
```
services:
  my-db:
    image: mysql
    environment:
      MYSQL_ROOT_PASSWORD: pwd1234
    volumes:
      - ./mysql_data:/var/lib/mysql
    ports:
      - 3306:3306
  my-cache-server:
    image: redis
    ports:
      - 6379:6379
```

### MySQL, Spring Boot 컨테이너 동시에 띄워보기
```
services:
  my-server:
    build: .
    ports:
      - 8080:8080
    depends_on:
      my-db:
        condition: service_healthy

  my-db:
    image: mysql
    environment:
      MYSQL_ROOT_PASSWORD: pwd1234
      MYSQL_DATABASE: mydb
    volumes:
      - ./mysql_data:/var/lib/mysql
    ports:
      - 3306:3306
    healthcheck:
      test: ["CMD", "mysqladmin", "ping"]
      interval: 5s
      retries: 20
```

-> mysql 연결이 안되는 문제 발생

![](https://velog.velcdn.com/images/dddingzong/post/f46482d3-3195-408f-b06c-842c4ed1e8e2/image.png)

-> 해결 방법

application.yml
![](https://velog.velcdn.com/images/dddingzong/post/5727a744-d077-4635-b2ce-fd0e7afdfc26/image.png)


### MySQL, Spring Boot, Redis 컨테이너 동시에 띄워보기

```
services:
  my-server:
    build: .
    ports:
      - 8080:8080
    depends_on:
      my-db:
        condition: service_healthy
      my-cache-server:
        condition: service_healthy

  my-db:
    image: mysql
    environment:
      MYSQL_ROOT_PASSWORD: pwd1234
      MYSQL_DATABASE: mydb
    volumes:
      - ./mysql_data:/var/lib/mysql
    ports:
      - 3306:3306
    healthcheck:
      test: ["CMD", "mysqladmin", "ping"]
      interval: 5s
      retries: 20

  my-cache-server:
    image: redis
    ports:
      - 6379:6379
    healthcheck:
      test: ["CMD", "redis-cli", "ping"]
      interval: 5s
      retries: 20
```

![](https://velog.velcdn.com/images/dddingzong/post/f2303dac-c9bb-4c93-be87-04de5d9c8416/image.png)





