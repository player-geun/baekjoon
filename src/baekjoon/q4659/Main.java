package baekjoon.q4659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String password;
        while (!(password = br.readLine()).equals("end")) {
            //입력 받은 문자열 조건 검사
            if (validatePasswordRule(password)) {
                System.out.println("<" + password + ">" + " is acceptable.");
            } else {
                System.out.println("<" + password + ">" + " is not acceptable.");
            }
        }
        //조건 검사 후 결과 리턴
    }

    public static boolean validatePasswordRule(String password) {
        //첫번째 조건: 특정 모음 하나이상 포함했는지
        if(!isContainedAlphabet(password)) return false;

        //두번째 조건: 같은 글자 연속 2번(ee, oo 제외)
        if(isContainedConsecutiveAlphabet(password)) return false;

        //세번째 조건: 모음 3개 or 자음 3개 연속x
        if(isThreeConsecutiveAlphabet(password)) return false;

        return true;
    }

    public static boolean isContainedAlphabet(String password) {
        if (password.contains("a")) {
            return true;
        }
        if (password.contains("e")) {
            return true;
        }
        if (password.contains("i")) {
            return true;
        }
        if (password.contains("o")) {
            return true;
        }
        if (password.contains("u")) {
            return true;
        }

        return false;
    }

    public static boolean isContainedConsecutiveAlphabet(String password) {
        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i - 1) == password.charAt(i) && password.charAt(i) != 'e' && password.charAt(i) != 'o') {
                return true;
            }
        }

        return false;
    }

    public static boolean isThreeConsecutiveAlphabet(String password) {
        for (int i = 2; i < password.length(); i++) {
            if (isVowel(password.charAt(i))) {
                if (isVowel(password.charAt(i - 1))) {
                    if (isVowel(password.charAt(i - 2))) {
                        return true;
                    }
                }
            }
            if (!isVowel(password.charAt(i))) {
                if (!isVowel(password.charAt(i - 1))) {
                    if (!isVowel(password.charAt(i - 2))) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean isVowel(char alphabet) {
        if (alphabet == 'a' || alphabet == 'i' || alphabet == 'o' || alphabet == 'e' || alphabet == 'u') {
            return true;
        }

        return false;
    }
}
