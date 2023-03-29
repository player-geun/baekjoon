package baekjoon.q1107;

import java.util.*;

public class Main {

    static final int currentChanel = 100;
    static int N, T, count;
    static int[] brokenButtons;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        T = sc.nextInt();
        brokenButtons = new int[T];

        for (int i = 0; i < T; i++) {
            brokenButtons[i] = sc.nextInt();
        }

        findPossibleMaxChanel();

        System.out.println(count);
    }

    public static void findPossibleMaxChanel() {
        int goalChanel = N;
        int plusChanel = N;
        int minusChanel = N;
        int plusCount = 0;
        int minusCount = 0;

        while (true) {
            String stringOfPlusChanel = String.valueOf(plusChanel);
            String stringOfMinusChanel = String.valueOf(minusChanel);
            boolean isPlusFailure = false;
            boolean isMinusFailure = false;

            for (int brokenButton : brokenButtons) {
                if (stringOfPlusChanel.contains(String.valueOf(brokenButton))) {
                    isPlusFailure = true;
                }

                if (stringOfMinusChanel.contains(String.valueOf(brokenButton))) {
                    isMinusFailure = true;
                }
            }

            if (isMinusFailure) {
                minusChanel--;
                minusCount++;
            }

            if (isPlusFailure) {
                plusChanel++;
                plusCount++;
            }

            if (!isPlusFailure || !isMinusFailure) {
                if (!isPlusFailure) {
                    plusCount += stringOfPlusChanel.length();

                    if (Math.abs(goalChanel - currentChanel) < plusCount) {
                        count = Math.abs(goalChanel - currentChanel);
                        return;
                    }
                    count = plusCount;
                    return;
                }

                if (!isMinusFailure) {
                    minusCount += stringOfMinusChanel.length();

                    if (Math.abs(goalChanel - currentChanel) < minusCount) {
                        count = Math.abs(goalChanel - currentChanel);
                        return;
                    }
                    count = minusCount;
                    return;
                }
            }
        }
    }
}
