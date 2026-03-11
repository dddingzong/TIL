
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	
    	int N = input.nextInt();
    	int[] arr = new int[N];
    	
    	for (int i =0;i<N;i++) {
    		arr[i] = input.nextInt();
    	}
    	
    	int left = 0;
    	int right = N-1;
    	int diff = Integer.MAX_VALUE;
    	int resultLeft = 0;
    	int resultRight = 0;
    	
    	while (left < right) {
    		
    		int sum = arr[left] + arr[right];
    		
    		if (Math.abs(sum) < diff) {
    			diff = Math.abs(sum);
    			resultLeft = arr[left];   
    			resultRight = arr[right];
    		}
    		
    		if (sum > 0) {
    			right--;
    		} else if (sum < 0) { 
    			left++;
    		} else {
    			break;
    		}
    	}
    	System.out.print(resultLeft + " " + resultRight);
    	
    	
    }
}