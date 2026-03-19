
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	
    	Scanner input = new Scanner(System.in);
    	int N = input.nextInt();
    	
    	PriorityQueue<Integer> que = new PriorityQueue<>();
    	
    	for (int i=0;i<N;i++) {
    		que.add(input.nextInt());
    	}
    	
    	
    	int result = 0;
    	
    	while (que.size() >1) {
    		int a = que.poll();
    		int b = que.poll();
    		result += a+b;
    		que.add(a+b);
    	}
    	
    	
    	System.out.print(result);
    }
}