

import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m;
	static int[][] arr;
	static int sum;
	static int[] dx = new int[] {1,0,-1,0};
	static int[] dy = new int[] {0,1,0,-1};
	static boolean[][] visited;
	
    public static void main(String[] args) throws IOException{
    
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] first = bf.readLine().split(" ");
    	n = Integer.parseInt(first[0]);
    	m = Integer.parseInt(first[1]);
    	
    	arr = new int[n][m];
		visited = new boolean[n][m];
    	
    	for (int i = 0;i<n;i++) {
        	String[] line = bf.readLine().split(" ");
    		for (int j=0;j<m;j++) {
    			arr[i][j] = Integer.parseInt(line[j]);
     		}
    	}
    	
    	int answer = 0;
    	for (int i = 0;i<n;i++) {
    		for (int j=0;j<m;j++) {
    			sum =0;
    			visited[i][j] = true;
    			int result = dfs(i,j,4,arr[i][j]);
    			visited[i][j] = false;
    			answer = Math.max(answer, result);
    			
    			
    			int tmp=0;
    			int cnt = 0;
    			int wing = 0;
    			int min = Integer.MAX_VALUE;
    			for (int k=0;k<4;k++) {
    				int ni = i + dx[k];
    				int nj = j + dy[k];
    				
    				if (ni < 0 || nj < 0 || ni >= n || nj >= m) continue;
    				
    				cnt++;
    				wing += arr[ni][nj];
    				min = Math.min(min, arr[ni][nj]);
    			}
    			
    			if (cnt == 4) {
    				tmp = wing + arr[i][j] - min;
    			} else if (cnt == 3) {
    				tmp = wing + arr[i][j];
    			}
    			
    			answer = Math.max(answer, tmp);
     		}
    	}
    	
    	System.out.print(answer);
    }
    
    static int dfs(int x, int y, int count, int vol) {
    	count--;
    	
    	if (count == 0) {
    		sum = Math.max(sum, vol);
    		return sum;
    	}
    	
    	for (int i=0;i<4;i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		
    		if (nx >= 0 && ny >=0 && nx < n && ny < m) {
    			if (visited[nx][ny] == true) continue;
    			visited[nx][ny] = true;
    			dfs(nx,ny,count,vol + arr[nx][ny]);
    			visited[nx][ny] = false;
    		}
    		
    	}
    	return sum;
    }
    
}

