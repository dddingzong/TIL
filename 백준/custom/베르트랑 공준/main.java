package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int count = 0;
        boolean[] isPrime = new boolean[2 * n];

        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i < Math.sqrt(2 * n); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 2 * n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = n + 1; i < isPrime.length; i++) {
            if (isPrime[i]) count++;
        }

        System.out.println(count);
        input.close();

    }

}