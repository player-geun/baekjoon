package baekjoon.q1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N, result;
    static List<Alphabet> alphabets;

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (checkConsecutive(word)) {
                result++;
            }
        }
    }

    public static void output() {
        System.out.println(result);
    }

    public static boolean checkConsecutive(String word) {
        char[] wordArr = word.toCharArray();
        alphabets = new ArrayList<>();

        for (int i = 0; i < wordArr.length; i++) {
            if (!checkDuplicate(wordArr[i])) {
                alphabets.add(new Alphabet(wordArr[i], 0));
            } else {
                if (alphabets.get(alphabets.size() - 1).name != wordArr[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkDuplicate(char alpha) {
        for (Alphabet alphabet : alphabets) {
            if (alphabet.name == alpha) {
                alphabet.count++;
                return true;
            }
        }

        return false;
    }

    public static class Alphabet {
        private char name;
        private int count;

        Alphabet(char name, int count) {
            this.name = name;
            this.count = count;
        }
    }
}
