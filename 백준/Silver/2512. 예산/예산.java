
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	
    	
    	int N = input.nextInt();
    	int[] assets = new int[N];
    	int sum = 0;
    	int max = Integer.MIN_VALUE;	
    	
    	for(int i=0;i<N;i++) {
    		assets[i] = input.nextInt();
    		sum += assets[i];
    		max = Math.max(max, assets[i]);
    	}
    	
    	int M = input.nextInt();
    	
    	if (M >= sum) {
    		System.out.println(max);
    		return;
    	}
    	
    	int left = 1;
    	int right = max;
    	int result =0;
    	
    	while (left <= right) {
        	int mid = (left + right) /2;
        	
        	
        	int total = 0;
        	for (int asset : assets) {
        		total += Math.min(asset, mid);
        	}
        	
        	if (total <= M) {
        		result = mid;
        		left = mid+1;
        	} else {
        		right = mid -1;
        	}
        	
        	
    	}
    	
    	System.out.println(result);
    	
    	
    	
    	
    	
    }
}