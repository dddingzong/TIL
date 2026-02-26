
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int M = input.nextInt();
        int N = input.nextInt();

        int start = (int)Math.ceil(Math.sqrt(M));
        int end   = (int)Math.floor(Math.sqrt(N));

        if (start > end) {
            System.out.println(-1);
            return;
        }

        int sum = 0;
        for (int i = start; i <= end; i++) {
        	sum += i * i;
        }

        System.out.println(sum);
        System.out.println(start * start);
    }
}