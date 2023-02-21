package baekjoon.q17266;

import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] lights;
    static int[] road;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        lights = new int[M];

        for (int i = 0; i < M; i++) {
            lights[i] = sc.nextInt();
        }

        System.out.println(findMinHeight(0, N));
    }

    public static int findMinHeight(int left, int right) {
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (validateAllLights(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static boolean validateAllLights(int height) {
        int endPoint = 0;
        for (int light : lights) {

            if (light - height <= endPoint) {
                endPoint = light + height;
            } else {
                return false;
            }
        }

        return N - endPoint <= 0;
    }
}
