
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		
		int W = input.nextInt();
		int H = input.nextInt();
		
		int N = input.nextInt();
		int M = input.nextInt();
		
		int result = 0;
		
		int x = W / (N+1);
		int y = H / (M+1);
		
		if (W % (N+1) !=0) {
			x++;
		}
		
		if (H % (M+1) !=0) {
			y++;
		}
		
		result = x*y;
		
		System.out.print(result);
		
		
		
	}
}
