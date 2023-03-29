package baekjoon.q2578;

import java.util.*;

public class Main {

    static int[][] board = new int[5][5];
    static int[][] numbersByHost = new int[5][5];
    static int countOfSayingHost = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                numbersByHost[i][j] = sc.nextInt();
            }
        }

        selectNumberByHost();

        System.out.println(countOfSayingHost);
    }

    public static void selectNumberByHost() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                checkNumberByHostInBoard(numbersByHost[i][j]);

                if (validateBingo()) {
                    countOfSayingHost = i * 5 + j + 1;
                    return;
                }
            }
        }
    }

    public static void checkNumberByHostInBoard(int numberByHost) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == numberByHost) {
                    board[i][j] = -1;
                }
            }
        }
    }

    public static boolean validateBingo() {
        int count = 0;

        //가로
        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;

            for (int j = 0; j < 5; j++) {
                if (board[i][j] != -1) {
                    isBingo = false;
                    break;
                }
            }

            if (isBingo) {
                count++;
            }
        }

        //세로
        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;

            for (int j = 0; j < 5; j++) {
                if (board[j][i] != -1) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) {
                count++;
            }
        }

        //대각선
        boolean isBingo = true;

        for (int i = 0; i < 5; i++) {
            if (board[i][i] != -1) {
                isBingo = false;
                break;
            }
        }

        if (isBingo) {
            count++;
        }

        int tempColumn = 4;
        isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (board[i][tempColumn--] != -1) {
                isBingo = false;
                break;
            }
        }

        if (isBingo) {
            count++;
        }

        if (count >= 3) {
            return true;
        }

        return false;
    }
}
