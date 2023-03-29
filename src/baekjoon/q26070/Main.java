package baekjoon.q26070;

import java.util.*;

public class Main {

    private static int X, Y, Z, A, B, C;
    private static long max;
    private static int[] gomgom;
    private static int[] tickets;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        X = sc.nextInt();
        Y = sc.nextInt();
        Z = sc.nextInt();
        tickets = new int[]{X, Y, Z};
        gomgom = new int[]{A, B, C};

        buyInFirstStage();

        buyInSecondStage();

        buyInThirdStage();

        System.out.println(max);
    }

    public static void buyInFirstStage() {
        for (int i = 0; i < 3; i++) {
            if (tickets[i] <= gomgom[i]) {
                max += tickets[i];
                gomgom[i] -= tickets[i];
                tickets[i] = 0;
            } else {
                max += gomgom[i];
                tickets[i] -= gomgom[i];
                gomgom[i] = 0;
            }
        }
    }

    public static void buyInSecondStage() {
        for (int i = 0; i < 3; i++) {
            if (tickets[i] > 0) {
                if (i == 2 && gomgom[0] > 0) {
                    if(gomgom[0] < tickets[2] / 3) {
                        max += gomgom[0];
                        tickets[2] -= gomgom[0] * 3;
                        gomgom[0] = 0;
                        continue;
                    }

                    max += tickets[2] / 3;
                    int temp = tickets[2] / 3;
                    gomgom[0] -= temp;
                    tickets[2] -= temp * 3;
                    continue;
                }

                if(i == 2) continue;

                if (gomgom[i + 1] > 0) {
                    if(gomgom[i + 1] < tickets[i] / 3) {
                        max += gomgom[i + 1];
                        tickets[i] -= gomgom[i + 1] * 3;
                        gomgom[i + 1] = 0;
                        continue;
                    }

                    max += tickets[i] / 3;
                    int temp = tickets[i] / 3;
                    gomgom[i + 1] -= temp;
                    tickets[i] -= temp * 3;
                }
            }
        }
    }

    public static void buyInThirdStage() {
        if (tickets[0] > 0 && gomgom[2] > 0) {
            if(gomgom[2] < tickets[0] / 9) {
                max += gomgom[2];
                tickets[0] -= gomgom[2] * 9;
                gomgom[2] = 0;
            } else {
                max += tickets[0] / 9;
                int temp = tickets[0] / 9;
                gomgom[2] -= temp;
                tickets[0] -= temp * 9;
            }
        }

        if (tickets[1] > 0 && gomgom[0] > 0) {
            if(gomgom[0] < tickets[1] / 9) {
                max += gomgom[0];
                tickets[1] -= gomgom[0] * 9;
                gomgom[0] = 0;
            } else {
                max += tickets[1] / 9;
                int temp = tickets[1] / 9;
                gomgom[0] -= temp;
                tickets[1] -= temp * 9;
            }
        }

        if (tickets[2] > 0 && gomgom[1] > 0) {
            if(gomgom[1] < tickets[2] / 9) {
                max += gomgom[1];
                tickets[2] -= gomgom[1] * 9;
                gomgom[1] = 0;
            } else {
                max += tickets[2] / 9;
                int temp = tickets[2] / 9;
                gomgom[1] -= temp;
                tickets[2] -= temp * 9;
            }
        }
    }
}
