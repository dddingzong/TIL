
import java.io.*;

public class Main {
	
	static int r,c,t;
	static int[][] arr;
	static int[][] tmp;
	static int[] dx = new int[] {1,0,-1,0};
	static int[] dy = new int[] {0,1,0,-1};
	static int topAir;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String[] first = bf.readLine().split(" ");
		r = Integer.parseInt(first[0]);
		c = Integer.parseInt(first[1]);
		t = Integer.parseInt(first[2]);
		arr = new int[r][c];		
		
		for (int i=0;i<r;i++) {
			String[] line = bf.readLine().split(" ");
			for (int j=0;j<c;j++) {
				arr[i][j] = Integer.parseInt(line[j]);
				if (arr[i][j] == -1 && topAir == 0) {
		            topAir = i;
		        }
			}
		}
		
		
		// 1 cycle
		// 미세먼지 확산
		// 기청정기 작동
		
		for (int i=0;i<t;i++) {
			cycle();
		}
		
		int result =0;
		for (int i=0;i<r;i++) {
			for (int j=0;j<c;j++) {
				if (arr[i][j] == -1) continue;
				result += arr[i][j];
			}
		}
		System.out.println(result);
		
	}
	
	static void cycle() {
	    spread();
	    air();
	}

	
	static void spread() {
		tmp = new int[r][c];
		
		// 확산 과정
		for (int i=0;i<r;i++) {
			for (int j=0;j<c;j++) {
				if (arr[i][j] <= 0) continue;
				
				int spl = 0;
				for (int k=0; k< 4;k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
							
					if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
						if (arr[nx][ny] == -1) continue;
						tmp[nx][ny] += arr[i][j]/5;
						spl += arr[i][j]/5;
					}
							
				}
				
				
						
				tmp[i][j] -= spl;
					
			}
		}
		
		for (int i=0;i<r;i++) {
			for (int j=0;j<c;j++) {
				arr[i][j] += tmp[i][j];
			}
		}

	}
	
	static void air() {
		tmp = new int[r][c];
		for (int i = 0; i < r; i++) {
		    for (int j = 0; j < c; j++) {
		        tmp[i][j] = arr[i][j];
		    }
		}
		
		// 상단
		for (int i=topAir-1; i>0;i--) tmp[i][0] = arr[i-1][0];
		for (int i=0;i<c-1;i++) tmp[0][i] = arr[0][i+1];
		for (int i=0;i<topAir;i++) tmp[i][c-1] = arr[i+1][c-1];
		for (int i=c-1;i>1;i--) tmp[topAir][i] = arr[topAir][i-1];
		// 하단
		for (int i = topAir+2;i<r-1;i++) tmp[i][0] = arr[i+1][0];
		for (int i=0; i<c-1;i++) tmp[r-1][i] = arr[r-1][i+1];
		for (int i=r-1; i > topAir+1; i--) tmp[i][c-1] = arr[i-1][c-1];
		for (int i=c-1;i>1;i--) tmp[topAir+1][i] = arr[topAir+1][i-1];
		tmp[topAir][1] = 0;
		tmp[topAir+1][1] = 0;
		tmp[topAir][0] = -1;
		tmp[topAir+1][0] = -1;
			
		for (int i=0;i<r;i++) {
			for (int j=0;j<c;j++) {
				arr[i][j] = tmp[i][j];
			}
		}
		
	}
		
}
	