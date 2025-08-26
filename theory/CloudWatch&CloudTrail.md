## CloudWatch&CloudTrail TIL

### EMR - Elastic MapReduce

**핵심 기능**
- Apache Hadoop, Spark, Presto 등 빅데이터 프레임워크 완전 관리
- EC2 스팟 인스턴스 활용으로 대규모 데이터 처리 비용 최적화
- S3, DynamoDB, RDS와 원활한 데이터 연동

### Glue - 서버리스 데이터 통합

**핵심 기능**
- 데이터 카탈로그를 통한 메타데이터 자동 검색 및 분류
- S3, Redshift, RDS 등 다양한 데이터 소스 간 변환 처리
- Apache Spark 기반 분산 처리로 대용량 데이터 변환

**활용 영역**
- Schema Registry로 스키마 진화 관리
- 서버리스 구조로 인프라 관리 부담 없이 사용

### Lake Formation - 데이터 레이크 구축

**핵심 기능**
- S3 기반 중앙 집중식 데이터 저장소 자동 구성
- 다양한 데이터 소스에서 데이터 수집 및 카탈로깅 자동화

### Rekognition - 이미지/비디오 분석 AI

**핵심 기능**
- 얼굴 감지, 인식, 비교 및 감정 분석
- 객체, 장면, 활동, 텍스트 인식 및 분류
- 부적절한 콘텐츠 자동 감지 및 필터링
- 실시간 비디오 스트림 분석 지원

### Comprehend - 자연어 처리 AI

**핵심 기능**
- 감정 분석, 엔티티 인식, 키 구문 추출
- 주제 모델링으로 문서 내 주요 주제 자동 식별
- 개인식별정보(PII) 자동 탐지 및 편집

**활용 영역**
- 의료 텍스트 특화 분석

### SageMaker - 머신러닝 플랫폼

**핵심 기능**
- Jupyter Notebook 기반 개발 환경 제공
- Built-in 알고리즘과 프레임워크 최적화 컨테이너
- 분산 훈련을 통한 대규모 모델 학습 지원

### CloudWatch - 모니터링 및 관찰 가능성

**핵심 기능**
- 메트릭 수집, 로그 관리, 알람 설정 통합 제공
- 대시보드를 통한 시각적 리소스 상태 모니터링
- Auto Scaling, SNS와 연동한 자동 대응 체계

**활용 영역**
- CloudWatch Logs Insights로 로그 쿼리 및 분석

### CloudTrail - API 호출 로깅 및 감사

**핵심 기능**
- 관리 이벤트와 데이터 이벤트 추적으로 상세 활동 로깅
- S3 버킷에 로그 파일 자동 저장 및 장기 보관
- CloudWatch Logs와 연동한 실시간 모니터링

### AWS Config - 리소스 구성 관리

**핵심 기능**
- 구성 기준선 대비 규정 준수 상태 자동 평가
- Configuration Snapshots로 특정 시점 리소스 상태 캡처
- Config Rules를 통한 보안 및 운영 정책 자동 검증
- 구성 변경 시 SNS 알림 및 Lambda 함수 트리거