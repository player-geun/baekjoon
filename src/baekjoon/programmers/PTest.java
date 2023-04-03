package baekjoon.programmers;

import java.util.Arrays;

public class PTest {

    private static final int[] first = {1, 2, 3, 4, 5};
    private static final int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public static void main(String[] args) {
        int[] answers = {1, 3, 2, 4, 2};

        int firstScore = gradeScore(answers, first);
        int secondScore = gradeScore(answers, second);
        int thirdScore = gradeScore(answers, third);

        int[] result = {firstScore, secondScore, thirdScore};

        Arrays.sort(result);


    }

    public static int gradeScore(int[] answers, int[] scoreOfPerson) {
        int score = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == scoreOfPerson[i % scoreOfPerson.length]) {
                score++;
            }
        }

        return score;
    }
}
