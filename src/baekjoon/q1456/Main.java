package baekjoon.q1456;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();
        long[] primeArr = new long[10000001];

        // 전체 배열 생성
        for (int i = 2; i < primeArr.length; i++) {
            primeArr[i] = i;
        }

        // 소수가 아닌 것들 모두 0 대입
        for (int i = 2; i <= Math.sqrt(primeArr.length); i++) {
            if (primeArr[i] == 0) {
                continue;
            }

            for (int j = i + i; j < primeArr.length; j += i) {
                primeArr[j] = 0;
            }
        }

        int count = 0;

        for (int i = 2; i < primeArr.length; i++) {
            if (primeArr[i] != 0) {
                long temp = primeArr[i];

                while ((double) primeArr[i] <= (double) B / (double) temp) {
                    if ((double) primeArr[i] >= (double) A / (double) temp) {
                        count++;
                    }

                    temp *= primeArr[i];
                }
            }
        }

        System.out.println(count);
    }
}
