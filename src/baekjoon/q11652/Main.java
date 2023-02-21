package baekjoon.q11652;

import java.util.*;

public class Main {

    static int N;
    static long mode;
    static long[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new long[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextLong();
        }

        Arrays.sort(numbers);


        int currentCount = 1;
        int modeCount = 1;
        mode = numbers[0];
        for (int i = 1; i < N; i++) {
            if (numbers[i] == numbers[i - 1]) {
                currentCount++;
            } else {
                currentCount = 1;
            }

            if (modeCount < currentCount) {
                mode = numbers[i];
                modeCount = currentCount;
            }
        }

        System.out.println(mode);
    }
}
