

import java.util.*;

public class Main {

    static int N;
    static int[] numbers;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 변수 선언
        N = input.nextInt();
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = input.nextInt();
        }

        Arrays.sort(numbers);

        average();
        mid();
        mode();
        range();
    }

    static void average() {
        Long sum = 0L;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println(Math.round((double)sum/N));
    }

    static void mid() {
        System.out.println(numbers[N/2]);
    }
    static void mode() {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int number : numbers) {
            countMap.put(number, countMap.getOrDefault(number, 0) + 1);
        }

        int maxCount = 0;
        for (int count : countMap.values()) {
            maxCount = Math.max(maxCount, count);
        }

        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                modes.add(entry.getKey());
            }
        }

        Collections.sort(modes);

        if (modes.size() > 1) {
            System.out.println(modes.get(1));
        } else {
            System.out.println(modes.get(0));
        }
    }

    static void range() {
        System.out.println(numbers[N-1] - numbers[0]);
    }


}


