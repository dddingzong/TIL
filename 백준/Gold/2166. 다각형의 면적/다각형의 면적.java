
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	
    	int N = input.nextInt();
    	Long[] xList = new Long[N];
    	Long[] yList = new Long[N];
    	
    	for (int i=0; i< N; i++) {
    		xList[i] = input.nextLong();
    		yList[i] = input.nextLong();
    	}
    	
    	Long result = 0L;
    	
    	for (int i=0; i< N-1; i++) {
    		result += xList[i] * yList[i+1] - xList[i+1] * yList[i];
    	}
    	result+= xList[N-1] * yList[0] - xList[0] * yList[N-1];
    	
    	System.out.printf("%.1f",Math.abs(result)/2.0);
    }
}