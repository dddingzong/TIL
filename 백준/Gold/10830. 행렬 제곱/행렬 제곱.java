

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = power(matrix, B, N);

        // 올바른 출력 방식
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");  // 각 행이 끝날 때 줄바꿈
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static int[][] power(int[][] matrix, long exp, int n) {
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            result[i][i] = 1;
        }

        while (exp > 0) {
            if (exp %2 == 1) {
                result = multiply(result, matrix, n);
            }
            matrix = multiply(matrix, matrix, n);
            exp /= 2;
        }

        return result;

    }

    static int[][] multiply(int[][] A, int[][] B, int n) {
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] = (result[i][j] + A[i][k] * B[k][j]) % 1000;
                }
            }
        }

        return result;
    }

}


