import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, M, r, c, d;
    static int[][] room;
    static int count = 1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};




    public static void main(String[] args) {
        // 반환값은 청소하는 영역의 개수
        // 방의 크기는 NxM
        // 왼쪽 위에가 (0,0) 오른쪽 아래는 (N-1, M-1)
        //
        // 현재 칸이 청소되지 않은 경우, 현재 칸을 청소한다
        // 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 없는 경우,
        // 한칸 후진한다. 뒤쪽이 벽이라면 작동을 멈춘다
        // 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 있는 경우,
        // 반시계 방향으로 90도 회전한다.
        // 바라보는 방향으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.

        // 첫째 줄에 방의 크기 N과 M입력
        // 둘쨰 줄에 로봇 청소기가 있는 칸의 좌표와 방향 입력 (0-북, 1-동, 2-남, 3-서)
        // 셋째 줄 부터는 공간표현

        // 변수 선언
        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        M = input.nextInt();
        r = input.nextInt();
        c = input.nextInt();
        d = input.nextInt();

        room = new int[N][M];

        input.nextLine();

        for (int i = 0; i < N; i ++) {
            int[] line = Arrays.stream(input.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int j=0; j < M; j++) {
                room[i][j] = line[j];
            }

        }

        // 로봇청소기 작동
        clean(r, c, d);
        System.out.print(count);

    }

    static void clean(int r, int c, int dir) {
        if (room[r][c]==0) {
            room[r][c] = -1;
        }

        for(int i = 0; i < 4; i++) {
            dir = (dir+3)%4;

            int nx = r + dx[dir];
            int ny = c + dy[dir];
            if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if(room[nx][ny] == 0) {
                    count++;
                    clean(nx, ny, dir);
                    return;
                }
            }
        }

        int d = (dir + 2) % 4;
        int bx = r + dx[d];
        int by = c + dy[d];
        if(bx >= 0 && by >= 0 && bx < N && by < M && room[bx][by] != 1) {
            clean(bx, by, dir);
        }
    }

}

