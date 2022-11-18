package baekjoon.review;

import java.util.Scanner;

/*
알고리즘 프로그래밍 과제2
2018125039 이근우
 */
public class Roma {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.next();
        int sum = 0;

        //우선순위에 따라 해당 로마 문자 숫자로 변환
        while (line.contains("IIV")) {
            line = line.replaceFirst("IIV", " ");
            sum += 3;
        }
        while (line.contains("IIX")) {
            line = line.replaceFirst("IIX", " ");
            sum += 8;
        }
        while (line.contains("IV")) {
            line = line.replaceFirst("IV", " ");
            sum += 4;
        }
        while (line.contains("IX")) {
            line = line.replaceFirst("IX", " ");
            sum += 9;
        }
        while (line.contains("I")) {
            line = line.replaceFirst("I", " ");
            sum += 1;
        }
        while (line.contains("V")) {
            line = line.replaceFirst("V", " ");
            sum += 5;
        }
        while (line.contains("X")) {
            line = line.replaceFirst("X", " ");
            sum += 10;
        }

        System.out.println(sum);
    }
}
