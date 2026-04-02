
import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m;
	static int[] dx = new int[]{1,0,-1,0};
	static int[] dy = new int[]{0,1,0,-1};
	static boolean[][] visited;
	static int[][] arr;
	static int result;
	
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
    	
    	
    	int cnt =0;
    	int volumn =0;
    		
    	for (int i = 0;i<n;i++) {
    		for (int j=0;j<m;j++) {
    			if (arr[i][j] == 1 && visited[i][j] == false) {
    				result = 1;
    				visited[i][j] = true;
    				int v = dfs(i,j);
    				cnt++;
    				volumn = Math.max(volumn, v);
    			}
    		}
    	}	
    	
    	System.out.println(cnt);
    	System.out.println(volumn);
    	
    }
    
    static int dfs(int x, int y) {
    	
    	for (int i=0;i<4;i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
        	
    		if (nx >= 0 && ny >= 0 && nx < n && ny <m) {
    			if (arr[nx][ny] == 0 || visited[nx][ny] == true) continue;
    			visited[nx][ny] = true;
    			result++;
    			dfs(nx,ny);			
    		}
    	}

    	return result;
    }
    
    
}
