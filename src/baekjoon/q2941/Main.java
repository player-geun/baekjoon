package baekjoon.q2941;

import java.util.Scanner;

public class Main {

    static String inputWord;
    static int alphabetCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inputWord = sc.next();

        findAlphabetCount();

        System.out.println(alphabetCount);
    }

    public static void findAlphabetCount() {
        while (!inputWord.equals("")) {
            if (inputWord.contains("dz=")) {
                inputWord = inputWord.replace("dz=", "");
                alphabetCount++;
            } else if (inputWord.contains("lj")) {
                inputWord = inputWord.replace("lj", "");
                alphabetCount ++;
            } else if (inputWord.contains("nj")) {
                inputWord = inputWord.replace("nj", "");
                alphabetCount ++;
            } else if (inputWord.contains("c=")) {
                inputWord = inputWord.replace("c=", "");
                alphabetCount ++;
            } else if (inputWord.contains("c-")) {
                inputWord = inputWord.replace("c-", "");
                alphabetCount ++;
            } else if (inputWord.contains("d-")) {
                inputWord = inputWord.replace("d-", "");
                alphabetCount ++;
            } else if (inputWord.contains("s=")) {
                inputWord = inputWord.replace("s=", "");
                alphabetCount ++;
            } else if (inputWord.contains("z=")) {
                inputWord = inputWord.replace("z=", "");
                alphabetCount ++;
            }
        }
    }
}
