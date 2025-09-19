

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int T = input.nextInt();
        String stringRoomNumber = null;
        List<String> answers = new ArrayList<>();

        for (int i = 0; i < T; i++) {

            int H = input.nextInt(); // 호텔의 층 수
            int W = input.nextInt(); // 층의 방 수
            int N = input.nextInt(); // 몇 번째 손님인지

            int floor = N%H;
            if (floor == 0) floor = H;

            int roomNumber = (N-1)/H + 1;
            if (roomNumber < 10) {stringRoomNumber = "0" + roomNumber;}
            if (roomNumber >= 10) {stringRoomNumber = String.valueOf(roomNumber);}

            String result = floor + stringRoomNumber;
            answers.add(result);
        }

        for (String answer : answers) {
            System.out.println(answer);
        }

    }
}

