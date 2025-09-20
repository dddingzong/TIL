


import java.util.Scanner;

public class Main {

    static int N;
    static int K;
    static int[] coins;
    static int[] dp;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        K = input.nextInt();
        coins = new int[N];

        for (int i = 0; i < N; i++) {
            int coin = input.nextInt();
            coins[i] = coin;
        }

        int count = 0;
        for (int i = N-1; i >= 0; i--) {
            if (K >= coins[i]) {
                count = count + K / coins[i];
                K %= coins[i];
            }

            if (K == 0) {
                break;
            }
        }
        System.out.println(count);
    }
}


