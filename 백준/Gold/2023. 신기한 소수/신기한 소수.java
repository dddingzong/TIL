
import java.util.*;

public class Main {
	
	static int n;
	static List<Integer> result = new ArrayList<>();
	
    public static void main(String[] args) {
    	
    	Scanner input = new Scanner(System.in);
    	n = input.nextInt();
    	
        for (int i = 1; i <= 9; i++) {
            if (isPrime(i)) {
                dfs(i, 1);
            }
        }

        Collections.sort(result);
        for (int number : result) {
            System.out.println(number);
        }        
    }
    
    static void dfs(int num, int depth) {
        if (depth ==n) {
            result.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            int next = num * 10 + i;
            if (isPrime(next)) {
                dfs(next, depth + 1);
            }
        }
    }
    
    static boolean isPrime(int number) {
    	if (number < 2) return false;
    	
    	for (int i=2;i*i<=number;i++) {
    		if (number%i==0) return false;
    	}
    	
    	return true;  	
    }
    
    
    
}