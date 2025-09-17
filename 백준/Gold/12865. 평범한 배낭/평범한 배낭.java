import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // N: 물건의 개수
        // W: 물건의 무게
        // V: 물건의 가치
        // K: 최대 무게
        // return: 배낭에 넣을 수 있는 물건들의 가치의 최대값

        // 첫 줄에서 물품의 수와 버틸 수 있는 무게 입력
        // 두번째 줄부터 각 물건의 무게와 물건의 가치 입력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] W = new int[N + 1]; // 무게
        int[] V = new int[N + 1]; // 가치
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <=N; i++) {
            for (int j = 1; j <= K; j++) {

                // i번째 무게를 더 담을 수 없는 경우
                if (W[i] > j) {
                    dp[i][j] = dp[i-1][j];
                }

                // i번째 무게를 더 담을 수 있는 경우
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}