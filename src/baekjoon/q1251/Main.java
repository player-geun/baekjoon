package baekjoon.q1251;

import java.util.*;

public class Main {

    static String word;
    static ArrayList<String> dividedWords;
    static ArrayList<String> newWords;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        newWords = new ArrayList<>();
        word = sc.next();

        selectTwoDividingPoint();

        Collections.sort(newWords);

        System.out.println(newWords.get(0));
    }

    public static void selectTwoDividingPoint() {
        for (int i = 1; i < word.length(); i++) {
            for (int j = i + 1; j < word.length(); j++) {
                dividedWords = new ArrayList<>();
                divideWordToThreePart(i, j);
                newWords.add(reverseThreeSubWord());
            }
        }
    }

    public static void divideWordToThreePart(int firstPoint, int secondPoint) {
        dividedWords.add(word.substring(0, firstPoint));
        dividedWords.add(word.substring(firstPoint, secondPoint));
        dividedWords.add(word.substring(secondPoint, word.length()));
    }

    public static String reverseThreeSubWord() {
        String newWord = "";
        for (String subWord : dividedWords) {
            StringBuilder sb = new StringBuilder();
            String reversedSubWord = sb.append(subWord).reverse().toString();
            newWord += reversedSubWord;
        }

        return newWord;
    }
}
