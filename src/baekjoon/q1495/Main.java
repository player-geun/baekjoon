package baekjoon.q1495;

import java.util.*;

public class Main {

    static int N, S, M;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        M = sc.nextInt();
        dp = new int[M + 1];

        for (int i = 0; i <= M; i++) {
            dp[i] = -1;
        }

        dp[S] = 0;

        for (int i = 1; i <= N; i++) {
            int volume = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j <= M; j++) {
                if (dp[j] == i - 1) { // i-1번째에서 가능한 볼륨들을 찾는다.
                    int res1 = j + volume;
                    int res2 = j - volume;

                    if (0 <= res1 && res1 <= M)
                        list.add(res1);
                    if (0 <= res2 && res2 <= M)
                        list.add(res2);
                }
            }

            for (int n : list) {
                dp[n] = i;
            }
        }

        int max = -1;
        for (int i = 0; i <= M; i++) {
            if (dp[i] == N)
                max = Math.max(max, i);
        }

        System.out.println(max);
    }
}
