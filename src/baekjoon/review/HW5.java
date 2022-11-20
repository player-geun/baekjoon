package baekjoon.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
알고리즘 프로그래밍 과제2
2018125039 이근우
 */
public class HW5 {

    static String word;
    static int[] failure;
    static int max;

    public static void main(String[] args) throws IOException {
        input();
        search();
        output();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
    }

    public static void search() {
        max = 0;

        for (int i = 0; i < word.length(); i++) {
            String subWord = word.substring(i);
            failureFuc(subWord);
            Arrays.sort(failure);

            if (max <= failure[subWord.length() - 1]) {
                max = failure[subWord.length() - 1];
            }
        }
    }
    public static void failureFuc(String subWord) {
        failure = new int[subWord.length()];
        int pointer = 0;
        int start = 1;

        while (start + pointer < subWord.length()) {
            if (subWord.charAt(pointer) == subWord.charAt(start + pointer)) {
                pointer++;
                failure[start + pointer - 1] = pointer;
            } else {
                if (pointer == 0) {
                    start++;
                } else {
                    start += (pointer - failure[pointer - 1]);
                    pointer = failure[pointer - 1];
                }
            }
        }
    }

    public static void output() {
        System.out.println(max);
    }
}
