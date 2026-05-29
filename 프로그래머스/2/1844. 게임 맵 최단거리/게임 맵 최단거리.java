import java.util.*;

class Solution {
    
    int dx[] = new int[]{1,0,-1,0};
    int dy[] = new int[]{0,1,0,-1};
    
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> que = new LinkedList<>();
        
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        que.add(new int[]{0,0,1});

        while (!que.isEmpty()) {
            int cur[] = que.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            
            // System.out.println("x = " + x + ", y = " + y + ", cnt = " + cnt);
        
            if (x==n-1 && y==m-1) {
                return cnt;
            }
            
            for (int i=0;i<4;i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if (nx >= 0 && ny >=0 && nx < n && ny <m) {
                    if (maps[nx][ny] == 0 | visited[nx][ny] == true) continue;
                    visited[nx][ny] = true;
                    que.add(new int[]{nx,ny,cnt+1});
                } // end if
            } // end for
        } // end while
        
        
        return -1;
        
    }
}