package baekjoon.q18310;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] house = new int[N];

        for (int i = 0; i < N; i++) {
            house[i] = sc.nextInt();
        }

        Arrays.sort(house);

        if (N % 2 == 0) {
            System.out.println(house[N / 2 - 1]);
        } else {
            System.out.println(house[N / 2]);
        }
    }
}
