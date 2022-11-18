package baekjoon.review;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] babbling = {"aya", "yee", "u", "maa", "wyeoo"};
        int answer = 0;

        for(String word : babbling) {
            if(word.contains("aya")) {
                word = word.replace("aya", "");
            }

            if(word.contains("ye")) {
                word = word.replace("ye", "");
            }

            if(word.contains("woo")) {
                word = word.replace("woo", "");
            }

            if(word.contains("ma")) {
                word = word.replace("ma", "");
            }

            System.out.println(word);

            if(word.equals("")) {
                answer++;
            }
        }
    }
}
