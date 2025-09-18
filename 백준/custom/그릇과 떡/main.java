package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 그릇과 떡
        // N개의 그릇 존재 (1~N 까지의 번호)
        // 그릇에는 떡이 하나만 들어간다
        // 떡을 M번 넣는다. 지정한 범위에 해당 떡을 둔다.
        // 범위는 연속해야한다.
        // 떡이 이미 있으면 덮어쓴다.
        // 첫째 줄에 N과 M이 주어진다. (1이상 100이하)
        // 두번째 줄에는 i, j, k가 주어진다.
        // i번째 그릇부터 j번째 그릇까지 k번 떡을 넣는다.

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int M = input.nextInt();
        int[] bowls = new int[N+1];

        for (int count = 0; count < M;  count++) {
            int i = input.nextInt();
            int j = input.nextInt();
            int k = input.nextInt();

            for (int bowl = i; bowl <= j; bowl++) {
                bowls[bowl] = k;
            }
        }

        for (int i =1; i <= N; i++) {
            System.out.print(bowls[i]);
            if (i != N) System.out.print(" ");
        }

        input.close();
    }
}