package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[] arr;
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = input.nextInt();
        }
        input.close();

        // LIS 배열
        ArrayList<Integer> lisArr = new ArrayList<>();
        lisArr.add(Integer.MIN_VALUE);

        int curr, end;
        for (int i=0; i<N; i++) {
            curr = arr[i];
            end = lisArr.size()-1;

            if (curr > lisArr.get(end)) {
                lisArr.add(curr);
            } else {
                /* 선형 탐색
                for (int j = 0; j < lisArr.size(); j++) {
                    if (lisArr.get(j) >= curr) {
                        lisArr.set(j,curr);
                        break;
                    }
                }
                 */

                // 이진 탐색
                int left = 0;
                int right = end;

                while (left<right) {
                    int mid = (left+right)/2;
                    if (lisArr.get(mid)<curr) {
                        left = mid+1;
                    } else {
                        right = mid;
                    }
                }
                lisArr.set(left,curr);

                for (int j = 1; j< lisArr.size(); j++) {
                    System.out.print(lisArr.get(j) + " ");
                }
                System.out.println();

            }
        }
        System.out.println(lisArr.size()-1);
    }
}