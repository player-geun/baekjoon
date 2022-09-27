package baekjoon.q1417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] vote = new int[N];
        int max = 0;
        int ds = 0;
        int num = 0;

        for (int i = 0; i < N; i++) {
            vote[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(0);
            return;
        }

        ds = vote[0];
        Arrays.sort(vote);

        while (max != ds) {
            int index = Arrays.binarySearch(vote, ds);
            vote[N - 1] -= 1;
            vote[index] += 1;
            ds = vote[index];
            Arrays.sort(vote);
            max = vote[N - 1];
            num++;
        }

        int a = 0;

        for (int i = 0; i < N; i++) {
            if (max == vote[i]) {
                a++;
            }
        }

        if (a > 1) {
            System.out.println(num + 1);
        } else {
            System.out.println(num);
        }
    }
}
