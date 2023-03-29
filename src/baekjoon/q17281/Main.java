package baekjoon.q17281;

import java.util.*;

public class Main {

    static int N, score;
    static int[][] playerOfStages;
    static boolean[] isSelected;
    static int[] sequenceOfTheseStage;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        playerOfStages = new int[N][10];

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < 10; j++) {
                playerOfStages[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            isSelected = new boolean[10];
            sequenceOfTheseStage = new int[10];

            // 1번은 항상 선택됨
            isSelected[1] = true;
            sequenceOfTheseStage[4] = 1;
        }

        findAllNumberOfCountAboutBaseballGame(1);

        System.out.println(score);
    }

    public static void findAllNumberOfCountAboutBaseballGame(int countOfSelectedPeople) {
        if (countOfSelectedPeople == 10) {
            // 각 이닝 별로 진행, 해당 이닝 게임 스타트 점수 계산
            int scoreOfStage = playBaseballGame();
            score = Math.max(score, scoreOfStage);
            return;
        }

        if (countOfSelectedPeople == 4) {
            findAllNumberOfCountAboutBaseballGame(countOfSelectedPeople + 1);
            return;
        }

        for (int i = 2; i < 10; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                sequenceOfTheseStage[countOfSelectedPeople] = i;
                findAllNumberOfCountAboutBaseballGame(countOfSelectedPeople + 1);
                isSelected[i] = false;
            }
        }
    }

    public static int playBaseballGame() {
        int outCount = 0;
        int numberOfPlayer = 1;
        int score = 0;

        for (int stage = 0; stage < N; stage++) {
            outCount = 0;
            int[] pos = new int[4];
            while (outCount != 3) {
                if (numberOfPlayer > 9) {
                    numberOfPlayer = 1;
                }

                if (playerOfStages[stage][sequenceOfTheseStage[numberOfPlayer]] == 0) {
                    outCount++;
                    numberOfPlayer++;
                } else if (playerOfStages[stage][sequenceOfTheseStage[numberOfPlayer]] == 1) {
                    if (pos[3] == 1) {
                        score++;
                    }
                    for (int i = 2; i > 0; i--) {
                        pos[i + 1] = pos[i];
                    }
                    pos[1] = 1;
                    numberOfPlayer++;
                } else if (playerOfStages[stage][sequenceOfTheseStage[numberOfPlayer]] == 2) {
                    if (pos[3] == 1) {
                        score++;
                    }
                    if (pos[2] == 1) {
                        score++;
                    }

                    pos[3] = pos[1];
                    pos[2] = 1;
                    pos[1] = 0;

                    numberOfPlayer++;
                } else if (playerOfStages[stage][sequenceOfTheseStage[numberOfPlayer]] == 3) {
                    if (pos[3] == 1) {
                        score++;
                    }
                    if (pos[2] == 1) {
                        score++;
                    }
                    if (pos[1] == 1) {
                        score++;
                    }

                    pos[3] = 1;
                    pos[2] = 0;
                    pos[1] = 0;

                    numberOfPlayer++;
                } else {
                    if (pos[3] == 1) {
                        score++;
                    }
                    if (pos[2] == 1) {
                        score++;
                    }
                    if (pos[1] == 1) {
                        score++;
                    }
                    score++;

                    pos[3] = 0;
                    pos[2] = 0;
                    pos[1] = 0;

                    numberOfPlayer++;
                }
            }
        }


        return score;
    }
}
