import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[] dx = new int[]{1,0,-1,0};
        int[] dy = new int[]{0,1,0,-1};

        boolean[][] visits = new boolean[n][m];
        Queue<int[]> que = new LinkedList<>(); 
        que.add(new int[]{0,0,1});
        int answer = 0;
        
        while(!que.isEmpty()) {
            int[] init = que.poll();

            int x = init[0];
            int y = init[1];
            answer = init[2];
            
            if (x==n-1&&y==m-1) {
                return answer;
            }
            
            for (int i=0;i<4;i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if (nx >= 0 &&
                    ny >= 0 &&
                    nx < n &&
                    ny < m && 
                    visits[nx][ny] == false && 
                    maps[nx][ny] == 1 ) 
                {
                    visits[nx][ny] = true;
                    que.add(new int[]{nx,ny,answer+1});
                }
            } 
        }

        return -1;
    }
}