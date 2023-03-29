package baekjoon.q1235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String[] studentNumbers;
    static int N, lengthOfStudentNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int k = 0;
        studentNumbers = new String[N];

        for (int i = 0; i < N; i++) {
            studentNumbers[i] = br.readLine();
        }

        lengthOfStudentNumber = studentNumbers[0].length();

        while (true) {
            if (isDifferentNumber(++k)) {
                break;
            }
        }

        System.out.println(k);
    }

    public static boolean isDifferentNumber(int k) {
        for (int i = 0; i < N; i++) {
            String number = studentNumbers[i].substring(lengthOfStudentNumber - k, lengthOfStudentNumber);
            for (int j = 0; j < N; j++) {
                if(i == j) continue;

                if (number.equals(studentNumbers[j].substring(lengthOfStudentNumber - k, lengthOfStudentNumber))) {
                    return false;
                }
            }
        }

        return true;
    }

}
