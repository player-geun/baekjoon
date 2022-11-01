package baekjoon.q4587;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static long M,N;
    public static void main(String[] args) throws NumberFormatException, IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            tokens = new StringTokenizer(input.readLine());
            M = Integer.parseInt(tokens.nextToken());
            N = Integer.parseInt(tokens.nextToken());

            if(M == 0 && N == 0) break;

            while(M!=1) {
                int nextN = (int) Math.ceil((double) N/M);
                while(true) {
                    long gcd = getGcd(N, nextN);

                    long lcm = N * nextN / gcd;

                    long newM1 = (lcm/N)*M;
                    long newM2 = lcm/nextN;
                    long newM = newM1 - newM2;

                    gcd = getGcd(newM, lcm);
                    newM = newM/gcd;
                    lcm = lcm/gcd;
                    if(lcm >= 1000000) {
                        nextN++;
                    }else {
                        System.out.print(nextN+" ");
                        N = lcm;
                        M = newM;
                        break;
                    }
                }
            }
            System.out.println(N+" ");
        }
    }

    private static long getGcd(long newM, long lcm) {
        long temp = 0;
        while(lcm>0) {
            temp = newM;
            newM = lcm;
            lcm = temp%lcm;
        }
        return newM;
    }
}
