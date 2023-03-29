package baekjoon.q2607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static String firstWord;
    private static int N, result;
    private static String[] words;
    private static StringBuilder sb;
    private static int[] alphabets;
    private static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        firstWord = br.readLine();
        words = new String[N - 1];
        alphabets = new int[26];

        for (int i = 0; i < N - 1; i++) {
            words[i] = br.readLine();
        }

        for(int i = 0; i < firstWord.length(); i++) {
            int w = firstWord.charAt(i) - 'A';
            alphabets[w]++;
        }

        for (String word : words) {
            validateSimilarKind(word);
        }

        System.out.println(result);
    }

    public static void validateSimilarKind(String word) {
        temp = alphabets.clone();
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            int w = word.charAt(i) - 'A';

            if(temp[w] > 0) {
                temp[w]--;
            } else {
                count++;
            }
        }

        if(firstWord.length() > word.length()) {
            count += firstWord.length() - word.length();
        }

        if(((firstWord.length() - word.length() == 0)
                || (Math.abs(firstWord.length() -  word.length()) == 1))
                && (count == 0 || count == 1)) {

            result++;
        }
    }
}
