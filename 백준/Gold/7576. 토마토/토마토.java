

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int dayCount = 0;
    static int M, N;
    static int[][] box;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        M = input.nextInt();
        N = input.nextInt();

        box = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = input.nextInt();
                if (box[i][j] == 1) queue.offer(new int[] {i, j});
            }
        }
        System.out.println(infect(queue));
    }

    static int infect(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean spread = false;

            for (int s = 0; s < size; s++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    // 범위 체크 & 안 익은 토마토인지 확인
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0) {
                        box[nx][ny] = 1;  // 익은 토마토로 변경
                        queue.offer(new int[]{nx, ny});
                        spread = true;
                    }
                }
            }

            if (spread) dayCount++;
        }
        
        // 모든 토마토가 익었는지 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    return -1;  // 안 익은 토마토가 있음
                }
            }
        }

        return dayCount;
    }
}


