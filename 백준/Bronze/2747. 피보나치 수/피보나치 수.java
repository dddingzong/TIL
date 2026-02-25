import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int[] nList = new int[n+1];
		nList[0] = 0;
		nList[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			nList[i] = nList[i-2] + nList[i-1]; 
		}
		
		System.out.print(nList[n]);
		
	}
}
