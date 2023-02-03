package baekjoon.q2110;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, C, min, max, mid;
    static int[] locationHouses;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        C = sc.nextInt();
        locationHouses = new int[N + 1];

        for (int i = 0; i < N; i++) {
            locationHouses[i] = sc.nextInt();
        }

        Arrays.sort(locationHouses);

        findMaxLength();

        System.out.println(mid);
    }

    public static void findMaxLength() {
        min = 1;
        max = locationHouses[N - 1] - locationHouses[0] + 1;

        while (min <= max) {
            mid = (min + max) / 2;

            if(canInstall(mid) >= C) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
    }

    public static int canInstall(int distance) {

        int count = 1;
        int lastLocate = locationHouses[0];

        for(int i = 1; i < locationHouses.length; i++) {
            int locate = locationHouses[i];

            if(locate - lastLocate >= distance) {
                count++;
                lastLocate = locate;
            }
        }
        return count;

    }
}
