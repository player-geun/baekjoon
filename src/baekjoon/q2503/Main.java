package baekjoon.q2503;

import java.util.*;

public class Main {

    static int N, count;
    static ArrayList<GameData> dataList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dataList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            dataList.add(new GameData(sc.next(), sc.nextInt(), sc.nextInt()));
        }

        for (int i = 123; i <= 987; i++) {
            if (isOverlapDigit(String.valueOf(i))) {
                continue;
            }
            validateRule(String.valueOf(i));
        }

        System.out.println(count);
    }

    public static boolean isOverlapDigit(String number) {
        if (number.charAt(0) == number.charAt(1) || number.charAt(2) == number.charAt(1)
                || number.charAt(2) == number.charAt(0) || number.charAt(0) == '0' ||
                number.charAt(1) == '0' || number.charAt(2) == '0') {
            return true;
        }
        return false;
    }

    public static void validateRule(String currentNumber) {
        // 각 자리별로 스트라이크 여부 체크
        for (GameData data : dataList) {
            int strike = 0;
            int ball = 0;

            // 스트라이크 볼 체크
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (data.answer.charAt(i) == currentNumber.charAt(j)) {
                        if (i == j) {
                            strike++;
                            continue;
                        }
                        ball++;
                    }
                }
            }

            // 불만족
            if (strike != data.strike || ball != data.ball) {
                return;
            }
        }

        count++;
    }

    public static class GameData {

        private String answer;
        private int strike;
        private int ball;

        public GameData(String answer, int strike, int ball) {
            this.answer = answer;
            this.strike = strike;
            this.ball = ball;
        }
    }
}
