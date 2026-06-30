class Solution {
    
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] arr = new int[n+1][m+1];
        
        for (int i =0; i < puddles.length; i++) {
            int tmpN = puddles[i][1];
            int tmpM = puddles[i][0];
            
            arr[tmpN][tmpM] = 1;
        }
        
        // for (int i =1; i <= n; i++) {
        //     for (int j=1; j <= m ;j++) {
        //         System.out.print(arr[i][j]); 
        //     }
        //     System.out.println();
        // }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) {
                    arr[i][j] = 1; 
                    continue;
                }
                if (arr[i][j] == 1) {
                    arr[i][j] = 0;
                    continue;
                }
                int up = (i > 1) ? arr[i-1][j] : 0;
                int left = (j > 1) ? arr[i][j-1] : 0;
                arr[i][j] = (up + left)% 1000000007;
            }
        }
        
        // answer = arr[n][m] % 1000000007;
        
        return arr[n][m];
    }
}