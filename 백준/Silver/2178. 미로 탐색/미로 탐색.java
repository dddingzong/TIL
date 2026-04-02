

import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m;
	static int[] dx = new int[]{1,0,-1,0};
	static int[] dy = new int[]{0,1,0,-1};
	static Queue<int[]> que;
	static boolean[][] visited;
	static int[][] arr;
	
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] first = bf.readLine().split(" ");
    	
    	n = Integer.parseInt(first[0]);
    	m = Integer.parseInt(first[1]);
    	arr = new int[n][m];
    	visited = new boolean[n][m];

    	que = new LinkedList<>();
    	int result = 0;
    	
    	for (int i=0;i<n;i++) {
    		String[] line = bf.readLine().split("");
        	for (int j=0;j<m;j++) {
        		arr[i][j] = Integer.parseInt(line[j]);
        	}
    	}
    	
    	que.add(new int[]{0,0});
    	visited[0][0] = true;
    	
    	while(!que.isEmpty()) {
    		int[] twoPoint = que.poll();
        	int x = twoPoint[0];
        	int y = twoPoint[1];
        	
        	if (x == n-1 && y == m-1) {
        		break;
        	}
        	
        	for (int i=0;i<4;i++) {
        		int nx = x + dx[i];
        		int ny = y + dy[i];
        		if (nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 1) {
        			if (visited[nx][ny] == true) continue;
        			visited[nx][ny] = true;
        			que.add(new int[] {nx,ny});
        			arr[nx][ny] = arr[x][y] + 1;
        		}
    		
        	}	
    	}
    	
    	System.out.println(arr[n-1][m-1]);
    	
    }

}