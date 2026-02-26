
import java.util.*;

public class Main {
    public static void main(String[] args) {
       
    	Scanner input = new Scanner(System.in);
    	
    	int N = input.nextInt();
    	int M = input.nextInt();
    	int[][] mat = new int[N][M];
    	
    	for (int i = 0; i < N; i++) {
        	for (int j = 0; j < M; j++) {
        		mat[i][j] = input.nextInt();
        	}
    	}
    	
    	int K = input.nextInt();
    	int[] answer = new int[K];
    	
    	for (int cycle = 0; cycle < K; cycle++) {
    		int sum = 0;
    		
    		int i = input.nextInt()-1;
    		int j = input.nextInt()-1;
    		int x = input.nextInt()-1;
    		int y = input.nextInt()-1;
    		
    		
        	for (int matx = i; matx <= x; matx++) {
            	for (int maty = j; maty <= y; maty++) {
            		sum += mat[matx][maty];
            	}
        	}
        	
        	answer[cycle] = sum;
    	}
        
        for(int i = 0; i < K;i++) {
        	System.out.println(answer[i]);
        }
       
    }
}