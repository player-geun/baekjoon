package baekjoon.q6588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {

    private static boolean[] prime;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int number;
        makePrime(1000000);

        while((number = Integer.parseInt(br.readLine())) != 0) {
            makePrimeSum(number);
        }

        System.out.println(sb);
    }

    public static void makePrimeSum(int number) {
        for (int i = 0; i < 1000001; i++) {
            if (!prime[i]) {
                int otherPrime = number - i;

                if (!prime[otherPrime]) {
                    sb.append(number).append(" = ").append(i).append(" + ").append(otherPrime).append("\n");
                    return;
                }
            }
        }

        sb.append("Goldbach's conjecture is wrong.");
    }

    public static void makePrime(int N) {
        prime = new boolean[N + 1];

        if(N < 2) {
            return;
        }

        prime[0] = prime[1] = true;

        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(prime[i] == true) {
                continue;
            }

            for(int j = i * i; j < prime.length; j = j+i) {
                prime[j] = true;
            }
        }

    }
}
