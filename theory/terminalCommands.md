## 유용한 터미널 명령어 모음

## 서론

개발하면서 터미널을 매일 사용하지만, 항상 기본적인 `ls`, `cd`, `mkdir` 정도만 사용하고 있었다.
좀 더 효율적인 작업을 위해 유용한 터미널 명령어들을 정리해보고자 한다.

생산성을 높이고 반복 작업을 줄일 수 있는 명령어들을 중심으로 학습해보자.

## 파일 검색 & 조작 명령어

### 1. find - 파일/디렉토리 찾기
```bash
# 현재 디렉토리에서 .java 파일 모두 찾기
find . -name "*.java"

# 특정 크기 이상의 파일 찾기 (10MB 이상)
find . -size +10M

# 최근 7일 내 수정된 파일 찾기
find . -mtime -7
```

### 2. grep - 텍스트 검색
```bash
# 파일 내용에서 특정 단어 찾기
grep -r "TODO" .

# 대소문자 무시하고 검색
grep -i "spring" *.java

# 줄 번호와 함께 출력
grep -n "public class" *.java

# 특정 패턴 제외하고 검색
grep -v "test" log.txt
```

### 3. awk - 텍스트 처리
```bash
# 특정 컬럼만 출력 (공백 기준)
ps aux | awk '{print $1, $11}'

# 파일 크기 합계 계산
ls -l | awk '{sum += $5} END {print sum}'
```

## 프로세스 관리 명령어

### 1. ps & kill - 프로세스 관리
```bash
# 실행 중인 Java 프로세스 찾기
ps aux | grep java

# 특정 포트 사용 중인 프로세스 찾기 (Windows)
netstat -ano | findstr :8080

# 프로세스 종료
kill -9 [PID]
```

### 2. nohup - 백그라운드 실행
```bash
# 터미널 종료해도 계속 실행되도록
nohup java -jar app.jar &

# 로그를 특정 파일로 저장
nohup java -jar app.jar > app.log 2>&1 &
```

## 네트워크 관련 명령어

### 1. curl - HTTP 요청 테스트
```bash
# GET 요청
curl http://localhost:8080/api/users

# POST 요청 (JSON)
curl -X POST -H "Content-Type: application/json" \
     -d '{"name":"test"}' \
     http://localhost:8080/api/users

# 응답 헤더만 보기
curl -I http://localhost:8080/health
```

### 2. ping & telnet - 연결 테스트
```bash
# 서버 응답 확인
ping google.com

# 특정 포트 연결 테스트
telnet localhost 8080
```

## 파일 압축 & 아카이브

### 1. tar - 파일 묶기/풀기
```bash
# 압축해서 묶기
tar -czf backup.tar.gz ./project

# 압축 풀기
tar -xzf backup.tar.gz

# 내용 확인 (풀지 않고)
tar -tzf backup.tar.gz
```

## Git과 함께 유용한 명령어

### 1. 파이프라인 조합
```bash
# 가장 많이 수정된 파일 TOP 10
git log --name-only --pretty=format: | sort | uniq -c | sort -rn | head -10

# 특정 확장자 파일의 총 라인 수
find . -name "*.java" | xargs wc -l | tail -1
```

## 개발 환경 설정

### 1. 환경 변수 & PATH
```bash
# 현재 환경 변수 확인
env | grep JAVA

# PATH에 디렉토리 추가 (임시)
export PATH=$PATH:/usr/local/bin

# 영구적으로 PATH 설정 (.bashrc 또는 .zshrc)
echo 'export PATH=$PATH:/usr/local/bin' >> ~/.bashrc
```

### 2. alias - 자주 쓰는 명령어 단축키
```bash
# .bashrc 또는 .zshrc에 추가
alias ll='ls -la'
alias gb='git branch'
alias gs='git status'
alias gp='git push'
alias start-app='java -jar target/app.jar'

# 현재 세션에서 바로 적용
source ~/.bashrc
```

## 결론

터미널 명령어를 잘 활용하면 개발 생산성이 크게 향상된다. 특히:

1. **반복 작업 자동화**: `alias`와 스크립트 활용
2. **효율적인 검색**: `find`, `grep` 조합으로 원하는 정보 빠르게 찾기
3. **시스템 모니터링**: 프로세스, 네트워크 상태 실시간 확인
4. **로그 분석**: 대용량 로그에서 필요한 정보만 추출

처음에는 복잡해 보이지만, 자주 사용하는 패턴들을 `alias`로 등록해두면
마우스 클릭 몇 번으로 해결하던 작업을 한 줄 명령어로 처리할 수 있다.

앞으로는 GUI 도구에만 의존하지 말고, 터미널을 더 적극적으로 활용해보자.