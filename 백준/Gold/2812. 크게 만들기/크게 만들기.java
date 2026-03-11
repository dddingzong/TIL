
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	
    	int N = input.nextInt();
    	int K = input.nextInt();
    	int[] numArr = new int[N];
    	
    	String number = input.next();
    	
    	String[] arr = number.split("");
    	
    	for (int i=0;i<N;i++) {
    		numArr[i] = Integer.parseInt(arr[i]);
    	}
    	
    	Deque<Integer> stack = new ArrayDeque<>();
    	
    	stack.push(numArr[0]);
    	
    	for (int i=1;i<N;i++) {
    		while (!stack.isEmpty() && numArr[i] > stack.peek() && K > 0) {
    			stack.pop();
    			K--;
    		}
    		stack.push(numArr[i]);
    	}
    	
    	int size = stack.size() - K;
    	Deque<Integer> result = new ArrayDeque<>();
    	
    	while (!stack.isEmpty()) {
    		result.push(stack.pop());
    	}
    	
    	int count = 0;
    	while (!result.isEmpty() && count < size) {
    	    System.out.print(result.pop());
    	    count++;
    	}
    	
    }
}