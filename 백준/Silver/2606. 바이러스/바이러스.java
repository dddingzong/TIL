

import java.util.Scanner;

public class Main {

    static boolean[] check;
    static int count = 0;

    static int[][] computers;
    static int node;
    static int line;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        node = input.nextInt();
        line = input.nextInt();

        check = new boolean[node+1];

        computers = new int[node+1][node+1];

        for (int i = 0;  i < line; i++) {
            int nodeOne = input.nextInt();
            int nodeTwo = input.nextInt();

            computers[nodeOne][nodeTwo] = computers[nodeTwo][nodeOne] = 1;
        }

        dfs(1);

        System.out.println(count - 1);

    }

    static void dfs(int start) {

        check[start] = true;
        count++;

        for (int i = 0; i <= node; i++) {
            if (computers[start][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }
}

