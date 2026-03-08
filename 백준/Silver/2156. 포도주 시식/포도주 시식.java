
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	
    	int n = input.nextInt();
    	int[] wines = new int[n+1];
    	int[] dp = new int[n+1];
    	
    	for (int i=1;i<=n;i++) {
    		wines[i] = input.nextInt();
    	}
    	
    	dp[1] = wines[1];
    	
    	if (n >= 2) dp[2] = wines[1] + wines[2];

        for (int i = 3; i <=n; i++) {
            dp[i] = Math.max(dp[i-1],                           
                    Math.max(dp[i-2] + wines[i],                
                             dp[i-3] + wines[i-1] + wines[i])); 
        }

    	
    	System.out.println(dp[n]);
    	
    }
}