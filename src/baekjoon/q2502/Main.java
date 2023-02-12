package baekjoon.q2502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 남은 알에 해당하는 문자열 개수 저장
        // R : 한 알 개수, C : 반 알 개수
        dp = new long[31][31];
        dp[1][0] = 1;
        dp[2][0] = 2;
        dp[3][0] = 5;

        eat(30, 0);

        int n = 0;
        while(true) {

            n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            System.out.println(dp[n][0]);
        }

    }

    private static long eat(int one, int half) {

        // 한 알 짜리가 없으면(반 알만 남을 경우)
        if(one == 0) return 1;
        // dp에 이미 저장되어있다면
        if(dp[one][half] != 0) return dp[one][half];

        long cnt = 0;
        // 한 알이 있으면
        if(one != 0) {
            // 한 알 꺼내보기
            cnt += eat(one - 1, half + 1);
        }
        // 반 알이 있으면
        if(half != 0) {
            // 반 알 꺼내보기
            cnt += eat(one, half - 1);
        }

        return dp[one][half] = cnt;
    }

}
