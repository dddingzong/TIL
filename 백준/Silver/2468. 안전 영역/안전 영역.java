

import java.util.*;
import java.io.*;

public class Main {
	
	static int n;
	static int[][] arr;
	static int max;
	static boolean[][] visited;
	static int[] dx = new int[]{1,0,-1,0};
	static int[] dy = new int[]{0,1,0,-1};
	
	
    public static void main(String[] args) throws IOException{
    
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] first = bf.readLine().split(" ");
    	n = Integer.parseInt(first[0]);

    	max =0;
    	arr = new int[n][n];
    	
    	for (int i = 0;i<n;i++) {
        	String[] line = bf.readLine().split(" ");
    		for(int j=0;j<n;j++) {
    			arr[i][j] = Integer.parseInt(line[j]);
    			max = Math.max(max, arr[i][j]);
    		}
    	}
    	
    	int answer = 0;
    	for (int i=0;i < max;i++) {
        	visited = new boolean[n][n];
    		int cnt = calculate(i);    	
      		answer = Math.max(answer, cnt);
    	}
    	  
    	
    	System.out.println(answer);
    }
    
    static int calculate(int h) {
    	int result = 0;
    	
    	for (int i=0;i<n;i++) {
    		for (int j=0;j<n;j++) {
    			if (arr[i][j] > h && visited[i][j] == false) {
    				visited[i][j] = true;
    				dfs(i,j,h);
    				result++;
    			}
    		}
    	}
    	
    	return result;
    }
    
    static void dfs(int x, int y, int h) {
    	for (int i=0;i<4;i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		
    		if (nx >=0 && ny >=0 && nx < n && ny < n){
    			if (arr[nx][ny] <= h || visited[nx][ny] == true) continue;
    			visited[nx][ny] = true;
    			dfs(nx,ny,h);
    		}
    		
    	}
    }
    
    
}








