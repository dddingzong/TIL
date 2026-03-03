
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	
    	int C = input.nextInt();
    	int N = input.nextInt();
    	int[] costList = new int[N];
    	int[] countList = new int[N];
    	int[] dp = new int[C+101];
    	
    	for (int i = 0; i < N; i++) {
    		costList[i] = input.nextInt();
    		countList[i] = input.nextInt();
    	}
    	
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[0] = 0;
    	
        for (int i = 0; i < N; i++) {
            for (int j = countList[i]; j < C + 101; j++) {
                if (dp[j - countList[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - countList[i]] + costList[i]);
                }
            }
        }
    	
        int answer = Integer.MAX_VALUE;
        for (int i = C; i < C + 101; i++) {
            answer = Math.min(answer, dp[i]);
        }
        System.out.println(answer);
    	
    	
    }
}