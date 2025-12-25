

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		int[][] Narr = new int[N+1][N+1];
		int[][] Marr = new int[M][4];
		int[][] dp = new int[N+1][N+1];
		 
		for (int i = 1; i <= N; i++) {
			for (int j =1; j <= N; j++) {
				Narr[j][i] = input.nextInt();	
			}
		}
		
		for (int i = 0; i < M; i++) {
			for (int j =0; j < 4; j++) {
				Marr[i][j] = input.nextInt();
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j =1; j <= N; j++) {
				dp[j][i] = dp[j][i-1] + Narr[j][i];
				
			}
		}
		
		
		for (int i =0; i<M;i++) {
			int x1 = Marr[i][0];
			int y1 = Marr[i][1];
			int x2 = Marr[i][2];
			int y2 = Marr[i][3];
			
			int result = 0;
			for (int j = y1; j <= y2; j++) {
				result += dp[j][x2] - dp[j][x1-1];
			}
			System.out.println(result);
			
			
		}
		

		
		
	}
}
