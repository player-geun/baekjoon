package baekjoon.q1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int[] set = new int[10];
        int maxValue = 0;
        int maxIndex = 0;

        for (int i = 0; i < line.length(); i++) {
            set[Integer.parseInt(line.substring(i, i + 1))]++;
        }

        for (int i = 0; i < 10; i++) {
            if (maxValue < set[i]) {
                maxValue = set[i];
                maxIndex = i;
            }
        }

        if (maxIndex == 6 || maxIndex == 9) {
            if (maxIndex == 6) {
                while (set[6] > set[9]) {
                    set[6]--;
                    set[9]++;
                }
            } else {
                while (set[6] < set[9]) {
                    set[6]++;
                    set[9]--;
                }
            }
            maxValue = 0;
            for (int i = 0; i < 10; i++) {
                if (maxValue < set[i]) {
                    maxValue = set[i];
                }
            }
        }

        System.out.println(maxValue);
    }
}
