
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		Long answer = 0L;
		
		for (int start=1, len=1; N >= start; start*=10, len++) {
			
			int end = start*10-1;
			
			if (end > N) {
				end = N;
			}
			
			answer += (long)(end-start+1)*len;
			
			
		}
		System.out.println(answer);
		bf.close();
	}
}
