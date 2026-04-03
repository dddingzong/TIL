

import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = new int[]{1,0,-1,0};
	static int[] dy = new int[]{0,1,0,-1};
	static int answer = 0;
	
    public static void main(String[] args) throws IOException{
    
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] first = bf.readLine().split(" ");
    	n = Integer.parseInt(first[0]);
    	m = Integer.parseInt(first[1]);

    	arr = new int[n][m];
    	visited = new boolean[n][m];
    	
    	for (int i = 0;i<n;i++) {
        	String[] line = bf.readLine().split(" ");
    		for(int j=0;j<m;j++) {
    			arr[i][j] = Integer.parseInt(line[j]);
    		}
    	}
    	
    	makeWall(0,0,0);
    	
    	System.out.println(answer);
    		
    	
    }
    
    static void makeWall(int sx, int sy, int count) {
    	if (count == 3) {
    		
    		int[][] temp = new int[n][m];
        	for (int i = 0;i<n;i++) {
        		for(int j=0;j<m;j++) {
        			temp[i][j] = arr[i][j];
        		}
        	}
    	
    		int result = simulate(temp);
    		answer = Math.max(answer, result);
    		return;
    	}
    	
    	
    	for (int i = sx;i<n;i++) {
    		int startJ = (i==sx) ? sy : 0;
    		for(int j=startJ;j<m;j++) {
    			if (arr[i][j] == 0) {
    				arr[i][j] = 1;
    				count++;
    				
    				if (j+1 <m) {
    					makeWall(i,j+1,count);
    				} else {
    					makeWall(i+1,0,count);
    				}
    				
    				arr[i][j] = 0;
    				count--;
    			}
    		}
    	}
    }
    
    static int simulate(int [][] temp) {
    	int result =0;
    	
    	for (int i = 0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			if (temp[i][j] == 2) {
     				dfs(i,j, temp);
    			}
    		}
    	}
    	
    	for (int i = 0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			if (temp[i][j] == 0) {
     				result++;
    			}
    		}
    	}
    	return result;
    }
    
    static void dfs(int x, int y, int[][] temp) {
    	for (int i=0;i<4;i++) {
        	int nx = x + dx[i];
        	int ny = y + dy[i];
        	
        	if (nx >=0 && ny >=0 && nx < n && ny <m) {
        		if (temp[nx][ny] != 0) continue;
        		temp[nx][ny] = 2;
        		dfs(nx,ny,temp);
        	}
        	
        	
    	}
    }

}








