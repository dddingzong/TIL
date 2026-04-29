import java.util.*;

class Solution {
    
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int answer = -1;
        
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        que.add(new int[]{0,0,1});
        visited[0][0] = true;
        
        while (!que.isEmpty()){
            int[] cur = que.poll();
            
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            
                        
            if (x == n-1 && y == m -1) {
                answer = cnt;
                break;
            }
            
            for (int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (maps[nx][ny] == 0 || visited[nx][ny] == true) continue;
                    que.add(new int[]{nx,ny,cnt+1});
                    visited[nx][ny] = true;
                    
                }
                
            }
            
            
        }
        
        
        return answer;
    }
}