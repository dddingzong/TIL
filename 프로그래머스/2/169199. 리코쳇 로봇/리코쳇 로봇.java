import java.util.*;

class Solution {
    
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};
    
    public int solution(String[] board) {
        int answer = 0;
        int r = 0; // 시작점 x
        int c = 0; // 시작점 y
        int n = board.length;
        int m = board[0].split("").length;
        
        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        
        for (int i=0;i<n;i++) {
            String[] st = board[i].split("");
            for (int j=0;j<m;j++) {
                int tmp = 0;
                String type = st[j];
                if (type.equals(".")) {
                    tmp = 0;
                } else if (type.equals("D")) {
                    tmp = 1;
                } else if (type.equals("R")) {
                    tmp = 2; 
                    r = i;
                    c = j;
                } else {
                    tmp = 3;
                }
                    
                arr[i][j] = tmp;
            }
        }
        // 0: 길, 1: 벽, 2: 현위치, 3: 목적지
        // for (int i=0;i<n;i++) {
        //     for (int j=0;j<m;j++) {
        //         System.out.print(arr[i][j] +" ");
        //     }
        //     System.out.println();
        // }
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{r,c,2,0});
        visited[r][c] = true;
        while (!que.isEmpty()){
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];
            int location = cur[2];
            int cnt = cur[3];
            
            if (location == 3) {
                return cnt;
            }
            
            for (int i=0;i<4;i++) {
                int nx = x;
                int ny = y;
                
                while (true) {
                    int nextx = nx + dx[i];
                    int nexty = ny + dy[i];
                    
                    // 다음 칸이 범위 밖이면 현재 위치에서 멈춤
                    if (nextx < 0 || nextx >= n || nexty < 0 || nexty >= m) {
                        break;
                    }
                    
                    // 다음 칸이 장애물이면 현재 위치에서 멈춤
                    if (arr[nextx][nexty] == 1) {
                        break;
                    }
                    
                    // 갈 수 있으면 이동
                    nx = nextx;
                    ny = nexty;
                }
                    
            // System.out.println("nx = " + nx + ", ny = " + ny);
                
            if (visited[nx][ny] == true) continue;
            visited[nx][ny] = true;
            que.add(new int[]{nx,ny,arr[nx][ny],cnt+1});
            }
                
                
        }
        return -1;
            
        }
    
    }
