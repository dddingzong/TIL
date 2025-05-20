package enumExample;

public class EnumMain {
    public static void main(String[] args) {
        PayCheck check = PayCheck.TRUE;

        // 메서드 호출을 통해 설명 출력
        System.out.println("현재 상태: " + check.getDescription());
    }
}