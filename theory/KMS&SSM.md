## KMS&SSM TIL

### KMS - Key Management Service

**핵심 기능**
- 암호화 키의 생성, 저장, 관리를 위한 완전 관리형 서비스
- Customer Managed Keys와 AWS Managed Keys로 구분하여 제공
- 키 순환 기능으로 보안 강화 및 규정 준수
- 다른 AWS 서비스와 원활한 통합으로 자동 암호화 적용

**활용 영역**
- S3, EBS, RDS 등 AWS 리소스 암호화
- 애플리케이션 레벨에서 Envelope Encryption 구현

### SSM - Systems Manager

**핵심 기능**
- Parameter Store를 통한 구성 데이터와 시크릿 중앙 집중 관리
- Systems Manager Agent를 통한 패치 관리 및 시스템 구성 자동화
- Run Command로 여러 인스턴스에 동시 명령 실행

### Secrets Manager

**핵심 기능**
- 데이터베이스, API 키, OAuth 토큰 등 민감한 정보 안전한 저장
- 자동 로테이션을 통한 시크릿의 주기적 갱신
- IAM 정책과 리소스 기반 정책을 통한 세밀한 액세스 제어
- VPC 엔드포인트를 통한 프라이빗 네트워크에서의 안전한 접근

**활용 영역**
- RDS, DocumentDB 등 데이터베이스 자격 증명 관리
- 마이크로서비스 간 API 키 및 토큰 공유

### GuardDuty - 지능형 위협 탐지

**핵심 기능**
- 머신러닝과 위협 인텔리전스를 활용한 이상 행동 자동 탐지
- VPC Flow Logs, DNS 로그, CloudTrail 이벤트 로그 분석
- 멀웨어, 암호화폐 채굴, 데이터 유출 등 다양한 위협 유형 탐지

### Inspector - 보안 취약점 평가

**핵심 기능**
- EC2 인스턴스와 컨테이너 이미지의 소프트웨어 취약점 자동 스캔
- 애플리케이션 보안 모범 사례 대비 구성 평가
- CVE 데이터베이스와 연동하여 알려진 취약점 탐지

### Macie - 데이터 보안 및 프라이버시

**핵심 기능**
- S3 버킷 내 민감한 데이터 자동 검색 및 분류
- GDPR, HIPAA 등 규정 준수를 위한 데이터 거버넌스 지원
- 데이터 보안 상태에 대한 상세한 대시보드와 보고서 제공

### VPC - Virtual Private Cloud

**핵심 기능**
- AWS 클라우드에서 논리적으로 격리된 가상 네트워크 환경 제공
- CIDR 블록을 통한 IP 주소 범위 정의 및 서브넷 분할
- 인터넷 게이트웨이, NAT 게이트웨이를 통한 인터넷 연결 제어
- Security Group과 Network ACL로 다층 보안 구현

**활용 영역**
- 온프레미스와 하이브리드 클라우드 연결
- VPC Peering과 Transit Gateway를 통한 네트워크 확장

### Subnet - 서브넷 구성

**핵심 기능**
- VPC 내에서 IP 주소 공간을 논리적으로 분할하는 네트워크 구성 요소
- Public Subnet과 Private Subnet으로 구분하여 보안 영역 분리
- 가용영역(AZ)별로 서브넷 배치하여 고가용성 아키텍처 구현
- 라우팅 테이블을 통한 트래픽 경로 제어

**활용 영역**
- 웹 서버는 Public Subnet, 데이터베이스는 Private Subnet 배치
- Multi-AZ 구성으로 장애 복구 능력 강화

### Gateway - 네트워크 게이트웨이

**핵심 기능**
- **Internet Gateway**: VPC와 인터넷 간 양방향 통신 경로 제공
- **NAT Gateway**: Private Subnet에서 인터넷으로의 단방향 아웃바운드 연결
- **VPC Endpoint Gateway**: S3, DynamoDB에 대한 프라이빗 연결 제공
- **Customer Gateway**: 온프레미스와 AWS 간 VPN 연결 지점

**활용 영역**
- 보안 요구사항에 따른 네트워크 트래픽 제어
- 하이브리드 클라우드 아키텍처에서 안전한 연결 보장