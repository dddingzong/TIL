package enumExample;

public enum PayCheck {
    TRUE("정산 완료"),
    FALSE("정산 미완료"),
    ISSUE("연체 금액 보유");

    private final String description; // 필드 추가

    // 생성자 추가
    PayCheck(String description) {
        this.description = description;
    }

    // 메서드 구현
    public String getDescription() {
        return description;
    }
}