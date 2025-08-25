## Lambda&APIGateway

### Lambda - 서버리스 컴퓨팅 서비스

- AWS의 완전 관리형 서버리스 컴퓨팅 플랫폼
- 이벤트 기반으로 코드를 실행하며 서버 관리 없이 애플리케이션 구축 가능
- Auto Scaling으로 트래픽 변화에 자동 대응
- VPC 연결을 통한 프라이빗 리소스 접근 가능
- CloudWatch 연동으로 실시간 모니터링 및 로깅
- API Gateway, S3, DynamoDB 등과 원활한 통합

### DynamoDB - NoSQL 데이터베이스 서비스

**핵심 특징**
- AWS의 완전 관리형 NoSQL 데이터베이스 서비스
- 키-값 및 문서 데이터 모델 지원
- 밀리초 단위의 빠른 응답 시간으로 고성능 애플리케이션에 적합
- 자동 스케일링으로 트래픽 변화에 탄력적 대응

**고급 기능**
- DynamoDB Streams로 데이터 변경 이벤트 캡처
- Point-in-Time Recovery로 35일 내 특정 시점 복구
- Global Tables로 다중 리전 복제 및 동기화
- DAX로 마이크로초 단위 응답 시간 달성

### API Gateway - API 관리 서비스

**API 유형별 특징**
- **REST API**: HTTP 기반 RESTful API, 완전한 기능 제공
- **HTTP API**: 빠르고 저렴한 HTTP API, 기본 기능에 집중
- **WebSocket API**: 실시간 양방향 통신 지원

**핵심 기능**
- Lambda 함수와의 완벽한 통합으로 서버리스 API 구축
- 자동 스케일링으로 동시 요청 처리
- API 키 관리 및 사용량 계획(Usage Plan) 설정
- 요청 검증, 응답 변환, CORS 지원

**보안 및 모니터링**
- Cognito, Lambda Authorizer를 통한 인증 및 권한 부여
- API 캐싱으로 성능 최적화 및 백엔드 부하 감소
- CloudWatch 연동 상세 모니터링 및 경보
- AWS WAF 통합 DDoS 보호 및 보안 강화

### Cognito - 사용자 인증 및 권한 관리

**User Pool (사용자 풀)**
- 회원가입, 로그인, 사용자 관리를 위한 사용자 디렉터리
- 이메일/전화번호 검증, MFA, 비밀번호 정책 설정
- 소셜 로그인(Google, Facebook, Apple) 연동
- Lambda 트리거를 통한 사용자 인증 플로우 커스터마이징

**Identity Pool (자격 증명 풀)**
- AWS 서비스 접근을 위한 임시 자격 증명 제공
- 인증된 사용자와 게스트 사용자 모두 지원
- IAM 역할 기반 세밀한 권한 제어
- 외부 자격 증명 공급자와의 통합

**보안 및 규정 준수**
- SAML 2.0, OpenID Connect 표준 지원
- GDPR, HIPAA 등 규정 준수 기능
- 고급 보안 기능(위험 기반 인증, 계정 탈취 보호)
- 사용자 데이터 내보내기 및 삭제 기능

### Athena - 서버리스 쿼리 서비스

**핵심 개념**
- S3에 저장된 데이터를 SQL로 직접 분석하는 서버리스 쿼리 서비스
- Apache Presto 기반으로 구축되어 높은 성능의 분산 쿼리 처리
- 스캔한 데이터 양에 따른 종량제 과금 모델

**고급 기능 및 통합**
- AWS Glue Data Catalog과 통합된 메타데이터 관리
- QuickSight, Jupyter Notebook 등 BI 도구와의 연동
- CloudTrail, VPC Flow Logs 등 AWS 서비스 로그 분석에 최적화

### RedShift - 데이터 웨어하우스 서비스

**아키텍처 및 성능**
- PostgreSQL 기반 페타바이트 규모 데이터 웨어하우스
- Massively Parallel Processing(MPP) 아키텍처로 고성능 분석
- 컬럼형 스토리지와 데이터 압축으로 스토리지 효율성 극대화

**고급 기능**
- **RedShift Spectrum**: S3 데이터를 직접 쿼리하여 데이터 레이크 통합
- **Materialized Views**: 복잡한 쿼리 결과를 미리 계산하여 성능 향상
- **Automatic Workload Management(WLM)**: 쿼리 우선순위 자동 관리
- **Concurrency Scaling**: 동시 사용자 증가 시 자동 클러스터 확장