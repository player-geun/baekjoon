package baekjoon.q2608;

import java.util.*;

public class Main {

    static String firstWord, secondWord;
    static HashMap<String, Integer> romaMap;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        firstWord = sc.next();
        secondWord = sc.next();
        romaMap = new HashMap<>();

    }

    public static void initRomaMap() {
        romaMap.put("I", 1);
        romaMap.put("IV", 4);
        romaMap.put("V", 5);
        romaMap.put("IX", 9);
        romaMap.put("X", 10);
        romaMap.put("XL", 40);
        romaMap.put("L", 50);
        romaMap.put("XC", 90);
        romaMap.put("C", 100);
        romaMap.put("CD", 400);
        romaMap.put("D", 500);
        romaMap.put("CM", 900);
        romaMap.put("M", 1000);
    }

    public static void changeRomaWordToInteger(String romaWord) {
        int sum = 0;
        boolean isUsedIV = false;
        boolean isUSedIX = false;
        boolean isUSedXL = false;
        boolean isUsedXC = false;
        boolean isUSedCD = false;
        boolean isUSedCM = false;

        for (int i = 0; i < romaWord.length() - 1; i++) {
            if (romaWord.substring(i, i + 2).equals("IV")) {
                if (!isUSedIX) {
                    sum += 4;
                    i++;
                    continue;
                }
            } else if (romaWord.substring(i, i + 2).equals("IX")) {
                if (!isUsedIV) {
                    sum += 9;
                    i++;
                    continue;
                }
            } else if (romaWord.substring(i, i + 2).equals("XL")) {
                if (!isUsedXC) {
                    sum += 40;
                }
            } else if (romaWord.substring(i, i + 2).equals("XC")) {
                if (!isUSedXL) {
                    sum += 90;
                    i++;
                    continue;
                }
            } else if (romaWord.substring(i, i + 2).equals("CD")) {
                if (!isUSedCM) {
                    sum += 400;
                    i++;
                    continue;
                }
            } else if (romaWord.substring(i, i + 2).equals("CM")) {
                if (!isUSedCD) {
                    sum += 900;
                    i++;
                    continue;
                }
            }


        }
    }

    public static void calculateTwoDigit(String romaWord, int index) {

    }
}
