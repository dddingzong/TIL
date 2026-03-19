
import java.util.*;

public class Main {

	static int N, M;
	static int[][] arr;
	static int[][][] dist;
	
	
	static int[] dx = new int[]{0,1,0,-1};
	static int[] dy = new int[]{1,0,-1,0};
    public static void main(String[] args) {
    	
    	Scanner input = new Scanner(System.in);
  
    	N = input.nextInt();
    	M = input.nextInt();
    	arr = new int[N][M];
    	dist = new int[N][M][2];
    	
    	for (int i = 0; i < N; i++) {
    	    String line = input.next();
    	    for (int j = 0; j < M; j++) {
    	        arr[i][j] = line.charAt(j) - '0';
    	        dist[i][j][0] = -1;
    	        dist[i][j][1] = -1;
    	    }
    	}

    	
    	System.out.println(bfs());
    	
    	
    }
    
    
    static int bfs() {
    	Queue<int[]> que = new LinkedList<>();
    	
    	que.offer(new int[] {0,0,0});
    	dist[0][0][0] = 1; // 초기값
    	
    	while (!que.isEmpty()) {
    		int[] curr = que.poll();
    		
    		int x = curr[0];
    		int y = curr[1];
    		int broken = curr[2];
    		
    		if (x==N-1&&y==M-1) {
    			return dist[x][y][broken];
    		}
    		
    		for (int i=0;i<4;i++) {
    			int nx = x+dx[i];
    			int ny = y+dy[i];
    			
    			if (nx<0 || nx >=N || ny<0 || ny>=M) continue;
    			
    			if (arr[nx][ny] == 0 && dist[nx][ny][broken]==-1) {
    				dist[nx][ny][broken] = dist[x][y][broken] +1;
    				que.offer(new int[] {nx,ny,broken});
    			}
    			
    			
    			if (arr[nx][ny] == 1 && broken==0 && dist[nx][ny][1]==-1) {
    				dist[nx][ny][1] = dist[x][y][broken] +1;
    				que.offer(new int[] {nx,ny,1});
    			}

    			
    		}

    	}
    	
    	return -1;
    }
    
    
    
    
    
    
    
    
    
}