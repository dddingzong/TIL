package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int number = input.nextInt();

        for (int i = 0; i < N -1 ; i++) {
            int secondNumber = input.nextInt();

            number = gcd(number, secondNumber);
        }

        System.out.println(number);
    }

    private static int gcd(int M, int N){
        int max = Math.max(M, N);
        int min = Math.min(M, N);

        while (true) {
            int r = max % min;
            if (r == 0) break;

            max = min;
            min = r;
        }

        return min;
    }
}