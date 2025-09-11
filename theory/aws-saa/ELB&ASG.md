# ELB & ASG TIL

## ELB (Elastic Load Balancer)
- AWS에서 제공하는 로드 밸런서 서비스
- 트래픽을 여러 인스턴스에 분산하여 고가용성 보장
- 헬스 체크를 통해 비정상 인스턴스 자동 제외
- 탄력적 확장으로 트래픽 증가에 대응
- ALB, NLB, GWLB 세 가지 타입 제공
- 리전 레벨 서비스로 AZ 장애에도 지속 운영
- SSL 종료 및 인증서 관리 기능 제공

## ALB (Application Load Balancer)
- Layer 7(애플리케이션 계층)에서 동작하는 로드 밸런서
- HTTP/HTTPS 트래픽 처리에 최적화
- 경로 기반 라우팅 및 호스트 기반 라우팅 지원
- WebSocket 및 HTTP/2 지원
- 마이크로서비스 아키텍처에 적합
- Target Group 기반으로 대상 관리
- WAF 통합으로 웹 애플리케이션 보안 강화

## NLB (Network Load Balancer)
- Layer 4(전송 계층)에서 동작하는 로드 밸런서
- TCP/UDP 트래픽 처리에 최적화
- 초당 수백만 건의 요청 처리 가능
- 정적 IP 주소 제공으로 방화벽 설정 용이
- 극도로 낮은 지연 시간 보장
- Cross-Zone Load Balancing 선택적 활성화
- 고성능이 필요한 애플리케이션에 적합

## GWLB (Gateway Load Balancer)
- Layer 3(네트워크 계층)에서 동작하는 로드 밸런서
- 방화벽, IDS/IPS 등 보안 어플라이언스 통합
- 인바운드/아웃바운드 트래픽 모두 처리
- VPC 엔드포인트를 통한 중앙집중식 보안 검사
- 복잡한 네트워크 보안 아키텍처에 활용

## Sticky Sessions
- 동일한 사용자의 요청을 같은 인스턴스로 지속 전달
- 세션 데이터가 로컬에 저장된 애플리케이션에 필요
- ALB와 CLB에서 지원, NLB는 미지원
- 인스턴스 장애 시 세션 데이터 손실 위험
- 로드 밸런싱 효율성 저하 가능성
- Redis 등 외부 세션 스토어 사용이 권장 대안

## SSL
- ELB에서 SSL/TLS 종료(Termination) 처리
- ACM(AWS Certificate Manager)과 연동한 인증서 관리
- HTTPS 리스너를 통한 암호화된 통신 지원
- SNI(Server Name Indication) 지원으로 다중 도메인 처리
- 인증서 자동 갱신으로 관리 부담 최소화
- 백엔드 인스턴스까지 암호화 연장 가능
- 보안 정책을 통한 암호화 알고리즘 제어

## ASG (Auto Scaling Group)
- EC2 인스턴스의 자동 확장/축소를 관리하는 서비스
- 최소/원하는/최대 인스턴스 수 설정으로 용량 제어
- 헬스 체크를 통한 비정상 인스턴스 자동 교체
- 다중 AZ에 인스턴스 분산으로 고가용성 보장
- Launch Template 또는 Launch Configuration 사용
- ELB와 통합하여 트래픽 분산과 확장성 동시 확보
- 비용 효율성과 성능 최적화 자동 달성

## ASG - 조정 정책
- **Target Tracking**: 지정된 메트릭 값 유지 (CPU 50% 등)
- **Step Scaling**: 단계별 확장/축소 (CloudWatch 알람 기반)
- **Simple Scaling**: 단순한 확장/축소 (쿨다운 기간 적용)
- **Predictive Scaling**: ML 기반 트래픽 패턴 예측 확장
- **Scheduled Scaling**: 예정된 시간에 용량 조정
- 여러 정책 동시 사용 가능 (가장 큰 변화량 적용)
- 스케일 아웃은 빠르게, 스케일 인은 점진적으로 권장

## RDS (Relational Database Service)
- AWS에서 관리하는 관계형 데이터베이스 서비스
- MySQL, PostgreSQL, MariaDB, Oracle, SQL Server 지원
- 자동 백업, 패치 관리, 모니터링 제공
- Multi-AZ 배포로 고가용성 보장
- Read Replica를 통한 읽기 성능 향상
- 자동 확장(Auto Scaling) 지원
- 완전 관리형으로 운영 부담 최소화

## Aurora
- AWS에서 개발한 클라우드 네이티브 관계형 데이터베이스
- MySQL 및 PostgreSQL과 호환
- 기존 RDS 대비 5배(MySQL) 또는 3배(PostgreSQL) 빠른 성능
- 자동으로 3개 AZ에 6개 복사본 생성
- 스토리지 자동 확장 (10GB~128TB)
- Aurora Serverless로 완전 자동 확장 가능
- 백트랙 기능으로 시점 복구 지원

## RDS Proxy
- 데이터베이스 연결을 관리하고 풀링하는 서비스
- 연결 풀링으로 데이터베이스 연결 효율성 향상
- Lambda 함수와 같은 서버리스 애플리케이션에 최적화
- 장애 조치 시간을 66%까지 단축
- IAM 및 AWS Secrets Manager와 통합한 보안 강화
- Aurora 및 RDS MySQL/PostgreSQL 지원
- 연결 급증으로 인한 데이터베이스 부하 문제 해결

## ElastiCache
- 완전 관리형 인메모리 데이터 저장소 서비스
- Redis 및 Memcached 엔진 지원
- 밀리초 미만의 응답 시간으로 고성능 실현
- 데이터베이스 부하 감소 및 애플리케이션 성능 향상
- 세션 스토어, 캐싱, 실시간 분석에 활용
- 자동 장애 조치 및 백업 지원(Redis)
- 클러스터 모드로 확장성 및 고가용성 보장