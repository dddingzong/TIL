
import java.util.*;

public class Main {
    public static void main(String[] args) {
       
    	Scanner input = new Scanner(System.in);
    	
    	int N = input.nextInt();
    	int M = input.nextInt();
    	int[] trees = new int[N];
    	int answer = 0;
    	
    	for (int i=0;i<N;i++) {
    		trees[i] = input.nextInt();
    	}
    	
    	Arrays.sort(trees);
    	
    	int left = 0;
    	int right = trees[N-1];
    	
    	while(left <= right) {
    		int mid = (left+right)/2;
    		Long sum = cut(trees,mid);
    	    
    		
    		if (sum >= M) {
    			answer = mid;
    			left = mid+1;
    		} else {
    			right = mid-1;
    		}

    	}

    	System.out.print(answer);
    }
    
    static private Long cut(int[] trees, int h) {
    	Long answer = 0L;
    	
    	for (int i=0;i<trees.length;i++) {
    		if (trees[i] > h) {
    			answer += trees[i]-h;
    		}
    	}

    	return answer;
    }
    
    
}