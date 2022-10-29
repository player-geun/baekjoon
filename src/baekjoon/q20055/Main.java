package baekjoon.q20055;

import java.util.Scanner;

public class Main {

    static int[] belt;
    static boolean[] robot;
    static int N, K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        belt = new int[2 * N];
        robot = new boolean[N];
        int level = 0;

        for (int i = 0; i < 2 * N; i++) {
            belt[i] = sc.nextInt();
        }

        while (isOK()) {
            // 1. 벨트 한 칸 회전
            int temp = belt[belt.length - 1];
            for (int i = belt.length - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = temp;
            //로봇도 벨트와 같이 회전
            for (int i = robot.length - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = false;
            robot[N - 1] = false;

            // 2. 로봇 이동가능하면 이동
            for (int i = N - 1; i > 0; i--) {
                if (robot[i - 1] && !robot[i] && belt[i] >= 1) {
                    robot[i] = true;
                    robot[i - 1] = false;
                    belt[i]--;
                }
            }

            // 3. 올라가는 위치에 로봇 올리기
            if (belt[0] > 0) {
                robot[0] = true;
                belt[0]--;
            }

            level++;
        }

        System.out.println(level);
    }

    public static boolean isOK() {
        int cnt = 0;

        for (int i = 0; i < belt.length; i++) {
            if (belt[i] == 0) {
                cnt++;
            }
            if (cnt >= K) {
                return false;
            }
        }
        return true;
    }
}
