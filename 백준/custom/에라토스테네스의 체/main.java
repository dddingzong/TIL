package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        boolean[] arr = new boolean[N+1];

        long startTime = System.currentTimeMillis(); // 시작 시간

        for (int i = 2; i <= N; i++) {
            arr[i] = true;
        }

        for (int i =2; i <= Math.sqrt(N); i++) {
            if (arr[i]) {
                for (int j = i*i; j <= N; j+=i) {
                    arr[j] = false;
                }
            }
        }

        for (int i = 2; i <=N; i++) {
            if (arr[i]) {
                System.out.println(i+ " ");
            }
        }


        long endTime = System.currentTimeMillis();
        double diffTimeSecond = (endTime - startTime)/1000.0;
        System.out.println("");
        System.out.println("diffTimeSecond = " + diffTimeSecond);

    }
}