package baekjoon.q1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static String word;
    static List<Alphabet> alphabets;

    public static void main(String[] args) {

    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
    }

    public void searchMaxAlphabet() {
        alphabets = new ArrayList<>();
        alphabets.add(new Alphabet(word.charAt(0), 0));

        for (int i = 1; i < word.length(); i++) {
            char name = word.charAt(i);

            for (Alphabet alphabet : alphabets) {
                if (alphabet.name == name) {
                    alphabet.count++;
                } else {
                    alphabets.add(new Alphabet(word.charAt(i), 0));
                }
            }
        }
    }

    public void output() {
        
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
