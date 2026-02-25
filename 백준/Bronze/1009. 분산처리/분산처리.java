
import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		int[] result = new int[T];
		
		for (int i = 0; i < T; i++) {
			
			int a = input.nextInt()%10;
			int b = input.nextInt();
			
			if (a == 0) {
			    result[i] = 10;
			  continue;
			}
			
			int[] loop = new int[5];
			loop[0] = a;
			int cycle =1;
			
			for (int j = 1; j < loop.length; j++) {
				loop[j] = (loop[j-1]*a)%10;
				if (loop[j] == loop[0]) break;
				cycle++;
			}

			int count = b % cycle;
			if (count == 0) count = cycle;
			result[i] = loop[count-1];
			
		}
		
		for (int i = 0; i < T; i++) {
			System.out.println(result[i]);
		}
		
		
	}
}
