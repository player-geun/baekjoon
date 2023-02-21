package baekjoon.q2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, a, b, sum;
    static int[] liquids;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        liquids = new int[N];
        st = new StringTokenizer(br.readLine());
        sum = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }

        countSum();

        System.out.println(a + " " + b);
    }

    public static void countSum() {
        Arrays.sort(liquids);

        for (int i = 0; i < N - 1; i++) {
            if(liquids[i] > 0) break;

            int index = upperBound(i + 1, N - 1, liquids[i] * -1);

            if (index - 1 < N && Math.abs(liquids[i] + liquids[index]) < Math.abs(liquids[i] + liquids[index - 1])) {
                if (sum > Math.abs(liquids[i] + liquids[index])) {
                    a = liquids[i];
                    b = liquids[index];
                    sum = liquids[i] + liquids[index];
                }
            }
            if(index < N && Math.abs(liquids[i] + liquids[index]) >= Math.abs(liquids[i] + liquids[index - 1])){
                if (sum > Math.abs(liquids[i] + liquids[index - 1])) {
                    a = liquids[i];
                    b = liquids[index - 1];
                    sum = liquids[i] + liquids[index - 1];
                }
            }
        }
    }

    public static int upperBound(int left, int right, int answer) {
        int result = right + 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (liquids[mid] < answer) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        return result;
    }
}
