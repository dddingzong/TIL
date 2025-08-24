## SQS&SNS TIL

### CloudFront - 콘텐츠 전송 네트워크(CDN)

- AWS의 글로벌 CDN 서비스로 전 세계 엣지 로케이션 활용
- 정적 및 동적 콘텐츠를 사용자에게 빠르게 배포
- 원본 서버 부하 감소 및 응답 속도 개선
- 실시간 로그와 CloudWatch 메트릭 제공
- Geo-restriction으로 지역별 접근 제어 가능

### Global Accelerator - 글로벌 네트워크 가속화

- AWS 글로벌 네트워크를 통한 트래픽 성능 개선
- 헬스 체크 기반 자동 장애 조치 기능
- Client Affinity 설정으로 세션 유지 지원
- 실시간 플로우 로그와 성능 메트릭 제공
- AWS Shield와 통합된 DDoS 보호

### Snow Family - 대용량 데이터 마이그레이션

- 오프라인 데이터 전송을 위한 물리적 디바이스 제공
- **Snowcone**: 8TB 용량의 소형 디바이스 (엣지 컴퓨팅 지원)
- **Snowball Edge**: 80TB~210TB 중형 디바이스 (컴퓨팅 기능 포함)
- **Snowmobile**: 페타바이트 규모 트레일러 기반 솔루션
- 대역폭 제한 환경이나 높은 전송 비용 상황에 효과적
- 대용량 마이그레이션, 재해 복구, 콘텐츠 배포 활용

### FSx - 완전 관리형 파일 시스템

**파일 시스템 종류**
- **FSx for Windows**: SMB 프로토콜, NTFS 지원
- **FSx for Lustre**: HPC 워크로드용 분산 파일 시스템

**데이터 보호 및 가용성**
- 자동 백업, 스냅샷, 암호화로 데이터 보호
- Multi-AZ 배포로 고가용성 및 내구성 보장
- SSD/HDD 스토리지 타입으로 성능-비용 최적화

**통합 및 모니터링**
- VPC 피어링, Direct Connect 하이브리드 환경 지원
- Microsoft Active Directory 통합 인증
- CloudWatch/CloudTrail 모니터링 및 감사 지원
- 온프레미스 파일 서버 대체 및 클라우드 마이그레이션

### Storage Gateway - 하이브리드 클라우드 스토리지

**게이트웨이 종류**
- **File Gateway**: NFS/SMB로 S3 파일 저장
- **Volume Gateway**: iSCSI 블록 스토리지 제공
- **Tape Gateway**: VTL 환경으로 백업 소프트웨어 호환

**핵심 기능**
- 로컬 캐시를 통한 빠른 데이터 액세스
- 데이터 압축 및 암호화로 효율성과 보안 확보
- CloudWatch 성능 모니터링 및 알림

**배포 및 활용**
- VM 또는 하드웨어 어플라이언스 배포
- 점진적 클라우드 마이그레이션 지원
- 기존 백업 인프라와 원활한 통합

### SQS - 메시지 큐 서비스

- AWS 완전 관리형 메시지 큐 서비스
- **Standard Queue**: 무제한 처리량, At-Least-Once 배송
- **FIFO Queue**: 순서 보장, Exactly-Once 배송
- Auto Scaling과 연계한 동적 확장
- 애플리케이션 간 느슨한 결합 구현

### SNS - 게시/구독 메시징 서비스

**핵심 개념**
- Pub/Sub 방식의 메시지 팬아웃 서비스
- 토픽 기반으로 다중 구독자 동시 메시지 전송

**지원 엔드포인트**
- SMS, 이메일, HTTP/HTTPS, Lambda, SQS 등 다양한 엔드포인트
- iOS, Android Mobile Push 알림 연동

**고급 기능**
- Message Filtering으로 선택적 메시지 수신
- Message Attributes로 메타데이터 기반 라우팅
- 재시도 정책과 DLQ로 실패 메시지 처리
- 서버 사이드 암호화(SSE)로 메시지 보호

**모니터링 및 아키텍처**
- CloudWatch 연동 성공률/실패율 모니터링
- 마이크로서비스 아키텍처 느슨한 결합 지원

### Kinesis - 실시간 데이터 스트리밍

**서비스 구성 요소**
- **Data Streams**: 실시간 데이터 수집 및 처리
- **Data Firehose**: S3, Redshift로 자동 데이터 전송
- **Data Analytics**: SQL 기반 실시간 스트림 분석
- **Video Streams**: 비디오 스트림 처리 (별도 서비스)

**핵심 특징**
- 샤드 기반 확장으로 높은 처리량 지원
- 최대 365일 데이터 보존 기간 설정
- 파티션 키 기반 데이터 분산 및 순서 보장

**활용 사례**
- Lambda 연동 실시간 처리 로직 구현
- IoT 센서, 로그 분석, 실시간 대시보드 구축