
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	
    	int K = input.nextInt();
    	int N = input.nextInt();
    	Long max = Long.MIN_VALUE;
    	Long[] lines = new Long[K];
    			
    	
    	for (int i=0;i<K;i++) {
    		lines[i] = input.nextLong();
    		max = Math.max(max, lines[i]);
    	}
    	
    	Long result = 0L;
    	Long left = 1L;
    	Long right = max;
    	
    	while (left <= right) {
        	Long mid = (left + right)/2;
    		
    	    long count = 0;
    	    for (long line : lines) {
    	        count += line / mid;
            }
    		
    	    if (count >= N) {
    	    	result = mid;
    	    	left = mid+1;
    	    } else {
    	    	right = mid-1;
    	    }
    		
 
    		
    	}
    	System.out.println(result);
    	
    }
}