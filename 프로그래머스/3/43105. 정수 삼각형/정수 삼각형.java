import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = Integer.MIN_VALUE;
        int n = triangle.length;
        int[][] dp = new int[n][];
        
        dp[0] = triangle[0];
        for (int i =1;i<n;i++) {
            int m = triangle[i].length;
            int[] tmp = new int[m];
            
            for (int j=0;j<m;j++) {
                if (j == 0) {
                    tmp[j] = dp[i-1][j] + triangle[i][j];
                } else if (j==m-1) {
                    tmp[j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    tmp[j] = Math.max(dp[i-1][j-1] + triangle[i][j], 
                                      dp[i-1][j] + triangle[i][j]);
                }
            }
            
            dp[i] = tmp;
        }
    
        
        for (int i=0;i< dp[n-1].length;i++) {
            answer = Math.max(dp[n-1][i], answer);
        }
        
        return answer;
    }
}