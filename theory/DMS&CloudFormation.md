## aude TIL

### DMS - Database Migration Service

**핵심 기능**
- 온프레미스와 AWS 데이터베이스 간 실시간 마이그레이션 서비스
- 동종/이종 데이터베이스 엔진 간 변환 지원 (Oracle → PostgreSQL, MySQL → Aurora 등)
- 마이그레이션 중 소스 데이터베이스의 다운타임 최소화

**구성 요소**
- **Replication Instance**: 실제 마이그레이션 작업을 수행하는 EC2 인스턴스
- **Source Endpoint**: 원본 데이터베이스 연결 정보
- **Target Endpoint**: 대상 데이터베이스 연결 정보
- **Replication Task**: 마이그레이션 규칙과 설정을 정의

### AWS 백업

**핵심 기능**
- 다양한 AWS 서비스에 대한 중앙 집중식 백업 관리
- 백업 정책 자동화 및 스케줄링으로 일관된 데이터 보호
- 크로스 리전 및 크로스 계정 백업으로 재해 복구 대비
- 백업 데이터의 암호화 및 액세스 제어 제공

**지원 서비스**
- **컴퓨팅**: EC2, EBS, EFS
- **데이터베이스**: RDS, DynamoDB, DocumentDB, Neptune
- **스토리지**: S3, FSx
- **하이브리드**: Storage Gateway, VMware 환경

### CloudFormation

**핵심 기능**
- JSON/YAML 템플릿을 통한 인프라 코드화(Infrastructure as Code)
- 스택 단위로 리소스 생성, 업데이트, 삭제의 일괄 관리
- Change Set을 통한 변경사항 미리보기 및 안전한 업데이트
- Cross-stack Reference로 스택 간 리소스 참조 및 의존성 관리

### SSM - Systems Manager

**Parameter Store**
- 구성 데이터와 시크릿을 계층적 구조로 중앙 관리
- Standard/Advanced 매개변수 티어로 용량과 정책 차별화
- KMS와 통합하여 민감한 데이터 암호화 저장
- 애플리케이션과 CloudFormation에서 런타임 참조 가능

**Systems Manager Agent**
- EC2 인스턴스와 온프레미스 서버의 원격 관리 도구
- Run Command로 여러 인스턴스에 동시 명령 실행
- Patch Manager를 통한 자동화된 패치 관리
- Session Manager로 브라우저 기반 셸 액세스 제공