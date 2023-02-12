package baekjoon.q15486;

import java.util.Scanner;

public class Main {

    static int N;
    static CalenderDay[] calender;
    static int[] dp;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        calender = new CalenderDay[N + 1];
        dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            calender[i] = new CalenderDay(sc.nextInt(), sc.nextInt());
        }
        int max = 0;

        for (int i = 1; i <= N; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }

            if (i + calender[i].time <= N + 1) {
                dp[i + calender[i].time] = Math.max(dp[i + calender[i].time], max + calender[i].money);
            }
        }

        for (int a : dp) {
            max = Math.max(max, a);
        }
        System.out.println(max);
    }

    public static class CalenderDay {

        private int time;
        private int money;

        public CalenderDay(int time, int money) {
            this.time = time;
            this.money = money;
        }
    }
}
