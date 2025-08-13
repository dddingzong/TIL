# @ControllerAdvice와 @ExceptionHandler를 활용한 예외 처리

## 서론
프로젝트를 진행하면서 처음으로 커스텀 Exception을 활용하면서 ControllerAdvice와 ExceptionHandler를 사용했다. 서비스 구현에서 원활한 예외 처리를 위해 이 개념들을 정리해보자.

## @ControllerAdvice란?
- Spring에서 전역 예외 처리를 담당하는 어노테이션
- 여러 컨트롤러에서 발생하는 예외를 한 곳에서 통합 관리
- @RestControllerAdvice는 @ControllerAdvice + @ResponseBody 조합

## @ExceptionHandler란?
- 특정 예외를 처리하는 메서드를 지정하는 어노테이션
- 메서드 레벨에서 사용되며, 처리할 예외 클래스를 지정

## PayPass Renewal 프로젝트 예시

### 1. 커스텀 예외 클래스 구현

#### ErrorResult Enum - 에러 타입 정의
```java
package com.project.paypass_renewal.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorResult {
    // 사용자 관련 에러
    USER_NUMBER_DUPLICATE(HttpStatus.BAD_REQUEST, "중복된 전화번호입니다."),
    NOT_EXIST_NUMBER(HttpStatus.BAD_REQUEST, "존재하지 않는 전화번호입니다."),
    USER_NOT_MATCH_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다."),
    
    // 연결 관련 에러
    LINK_USER_AND_SUPPORTER_DUPLICATE(HttpStatus.BAD_REQUEST, "이미 등록된 이용자와 보호자입니다."),
    LINK_CODE_NOT_EXIST(HttpStatus.BAD_REQUEST, "일치하는 연결 코드가 존재하지 않습니다."),
    
    // 기타 에러
    NOT_EXIST_ZIPCODE(HttpStatus.BAD_REQUEST, "존재하지 않는 우편번호입니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
```

#### CustomException - 커스텀 예외 클래스
```java
package com.project.paypass_renewal.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private final ErrorResult errorResult;

    public CustomException(ErrorResult errorResult) {
        super(errorResult.getMessage());
        this.errorResult = errorResult;
    }
}
```

### 2. 전역 예외 처리 (Global Exception Handler)

```java
package com.project.paypass_renewal.exception.handler;

import com.project.paypass_renewal.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 커스텀 예외 처리
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Map<String, Object>> handleCustomException(CustomException exception) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("message", exception.getErrorResult().getMessage());
        errorResponse.put("status", exception.getErrorResult().getHttpStatus().value());

        log.warn("CustomException 발생: {}", exception.getErrorResult().getMessage());

        return ResponseEntity
            .status(exception.getErrorResult().getHttpStatus())
            .body(errorResponse);
    }
}
```

### 3. 특정 컨트롤러 예외 처리

```java
package com.project.paypass_renewal.exception.handler.user;

import com.project.paypass_renewal.controller.UserController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
// UserController에서만 적용되는 예외 처리
@RestControllerAdvice(assignableTypes = UserController.class)
public class UserControllerExceptionHandler {

    // @Valid 유효성 검증 실패 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(
            MethodArgumentNotValidException exception) {
        
        Map<String, Object> errorResponse = new HashMap<>();

        // 첫 번째 필드 에러 메시지 추출
        String errorMessage = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .orElse("유효성 검증 실패");

        errorResponse.put("message", errorMessage);
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());

        log.warn("Validation failed: {}", errorMessage);

        return ResponseEntity.badRequest().body(errorResponse);
    }

    // @JsonFormat 날짜 형식 오류 처리
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> handleJacksonParseException(
            HttpMessageNotReadableException exception) {
        
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("message", "날짜 형식이 올바르지 않습니다. yyyy-MM-dd 형식을 사용하세요.");
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.badRequest().body(errorResponse);
    }
}
```

## 활용 예시 - Service Layer에서 예외 발생

```java
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void register(UserDto userDto) {
        // 전화번호 중복 체크
        if (userRepository.existsByPhoneNumber(userDto.getPhoneNumber())) {
            throw new CustomException(ErrorResult.USER_NUMBER_DUPLICATE);
        }
        
        // 회원 가입 로직...
    }
    
    public void login(LoginDto loginDto) {
        User user = userRepository.findByPhoneNumber(loginDto.getPhoneNumber())
            .orElseThrow(() -> new CustomException(ErrorResult.NOT_EXIST_NUMBER));
        
        // 비밀번호 검증
        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new CustomException(ErrorResult.USER_NOT_MATCH_PASSWORD);
        }
        
        // 로그인 처리...
    }
}
```

## 장점

### 1. 중앙 집중식 예외 처리
- 예외 처리 로직을 한 곳에서 관리
- 코드 중복 제거

### 2. 일관된 응답 형식
- 모든 에러 응답이 동일한 구조를 가짐
- 클라이언트에서 예측 가능한 에러 처리

### 3. 관심사 분리
- 비즈니스 로직과 예외 처리 로직 분리
- 컨트롤러 코드가 깔끔해짐

### 4. 유연한 예외 처리
- 전역 예외 처리와 컨트롤러별 예외 처리 병행 가능
- 다양한 예외 타입에 대한 세밀한 제어

## 주의사항

### 1. 예외 처리 우선순위
- 더 구체적인 예외 핸들러가 우선 적용
- 특정 컨트롤러용 > 전역 처리

### 2. 응답 형식 통일
- 프로젝트 전체에서 일관된 에러 응답 구조 유지
- API 문서화 시 에러 응답도 명세

### 3. 로깅
- 예외 발생 시 적절한 로그 레벨 사용
- 디버깅을 위한 충분한 정보 기록

## 정리
@ControllerAdvice와 @ExceptionHandler를 활용하면 Spring 애플리케이션에서 체계적이고 일관된 예외 처리가 가능하다. PayPass Renewal 프로젝트에서는 커스텀 예외와 함께 사용하여 비즈니스 로직에서 발생하는 다양한 예외 상황을 효과적으로 관리하고 있다.
