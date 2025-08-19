## SAA 공부 - IAM & EC2

### 서론 
SAA 자격증 취득을 위해서 공부를 시작했습니다. AWS에 관해 공부하고 싶었는데 겸사겸사 취득할 예정입니다.
서버 아키텍처가 너무 약해서 AWS 공부하고 토이프로젝트 진행하면서 활용 잘 해보도록 하겠습니다. 
오늘은 그냥 SAA 공부하면서 학습한 내용을 정리하겠습니다.

### 본론

#### IAM User, Group 

**IAM User**
- AWS 계정과 상호작용할 수 있는 개체
- Root 사용자는 모든 권한을 가지므로 일상적인 작업에는 사용 금지
- 최소 권한 원칙 적용

**IAM Group**
- 여러 사용자를 묶어서 관리하는 컬렉션
- 그룹에 정책을 연결하면 모든 구성원이 해당 권한을 상속
- 사용자는 여러 그룹에 속할 수 있음
- 중첩된 그룹은 지원하지 않음

#### IAM Policies

**정책의 구조**
- JSON 형식의 문서로 권한을 정의
- Effect: Allow/Deny
- Action: 수행할 수 있는 작업 (예: s3:GetObject)
- Resource: 작업을 수행할 리소스의 ARN
- Condition: 정책이 적용되는 조건 (선택사항)

#### IAM MFA

**Multi-Factor Authentication (다단계 인증)**
- 비밀번호 + 추가 보안 요소를 결합한 인증 방식
- Root 사용자와 IAM 사용자 모두 설정 가능

**MFA 디바이스 유형**
- **Virtual MFA Device**: Google Authenticator, Authy 등 앱
- **U2F Security Key**: YubiKey 등 물리적 키
- **Hardware MFA Device**: 전용 하드웨어 토큰

#### AWS CLI

**AWS Command Line Interface**
- 터미널에서 AWS 서비스와 상호작용할 수 있는 도구
- AWS SDK의 대안으로 스크립트 및 자동화에 유용
- `aws configure`로 Access Key ID, Secret Access Key 설정

**주요 명령어 예시**
```bash
aws s3 ls                          # S3 버킷 목록
aws ec2 describe-instances         # EC2 인스턴스 조회
aws iam list-users                 # IAM 사용자 목록
```

#### AWS Cloud Shell

- AWS Management Console에서 직접 실행 가능
- AWS CLI, Git, Docker 등 사전 설치됨
- 추가 설정 없이 현재 로그인한 사용자 권한으로 실행

#### IAM Role

- AWS 서비스나 외부 엔티티가 임시적으로 권한을 가질 수 있게 하는 방법

#### EC2

- AWS의 가상 서버 서비스
- 다양한 인스턴스 타입과 크기 제공
- 온디맨드, 예약 인스턴스, 스팟 인스턴스 등 다양한 구매 옵션

#### EC2 Instance

- 인스턴스에 대한 정보를 제공하는 서비스
- 인스턴스 ID, 퍼블릭 IP, IAM 역할 정보 등 확인 가능

#### EC2 Security

- 가상 방화벽 역할
- 인바운드 및 아웃바운드 트래픽 제어
- 기본적으로 모든 아웃바운드 허용, 모든 인바운드 거부
- Stateful: 허용된 인바운드에 대한 응답은 자동으로 아웃바운드 허용

#### SSH

**Secure Shell Protocol**
- Linux/Mac 인스턴스에 안전하게 연결하는 방법
- 공개키 암호화 방식 사용

**Key Pair**
- **Public Key**: AWS가 인스턴스에 보관
- **Private Key**: 사용자가 로컬에 보관 (.pem 파일)
- 인스턴스 생성 시 지정하거나 기존 키 페어 사용

**연결 방법**
```bash
# Linux/Mac
ssh -i "my-key.pem" ec2-user@public-ip

# Windows (PuTTY 사용)
# .pem을 .ppk로 변환 후 PuTTY에서 사용
```

#### EC2 Instance Role

- EC2에서 다른 AWS 서비스에 접근할 때 안전한 방법
- Access Key를 하드코딩하지 않고 임시 자격 증명 사용
- 자격 증명 자동 로테이션
