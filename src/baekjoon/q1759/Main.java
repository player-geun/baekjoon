package baekjoon.q1759;

import java.util.*;

public class Main {

    static int L, C;
    static String[] alphabets;
    static ArrayList<String> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        alphabets = new String[C];
        result = new ArrayList<>();

        HashMap<Integer, Integer> a = new HashMap<>();


        for (int i = 0; i < C; i++) {
            alphabets[i] = sc.next();
        }

        Arrays.sort(alphabets);

        selectAlphabets(0, "");

        Collections.sort(result);

        for (String ciphertext : result) {
            System.out.println(ciphertext);
        }
    }

    public static void selectAlphabets(int start, String ciphertext) {
        if (ciphertext.length() == L) {
            if (validateOneRule(ciphertext) && validateTwoRule(ciphertext)) {
                result.add(ciphertext);
            }

            return;
        }

        for (int i = start; i < C; i++) {
            selectAlphabets(i + 1, ciphertext + alphabets[i]);
        }
    }

    public static boolean validateOneRule(String ciphertext) {
        for (int i = 0; i < ciphertext.length(); i++) {
            if (ciphertext.charAt(i) == 'i' || ciphertext.charAt(i) == 'o' || ciphertext.charAt(i) == 'u'
                    || ciphertext.charAt(i) == 'a' || ciphertext.charAt(i) == 'e') {
                return true;
            }
        }

        return false;
    }

    public static boolean validateTwoRule(String ciphertext) {
        int count = 0;
        for (int i = 0; i < ciphertext.length(); i++) {
            if (!(ciphertext.charAt(i) == 'i' || ciphertext.charAt(i) == 'o' || ciphertext.charAt(i) == 'u'
                    || ciphertext.charAt(i) == 'a' || ciphertext.charAt(i) == 'e')) {
                count++;
            }
        }

        if (count >= 2) {
            return true;
        }

        return false;
    }
}
