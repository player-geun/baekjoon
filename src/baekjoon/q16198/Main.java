package baekjoon.q16198;

import java.util.*;
import java.util.stream.*;

public class Main {

    static int N, maxSumOfEnergy;
    static int[] beadsArr;
    static List<Integer> beads;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        beadsArr = new int[N];

        for (int i = 0; i < N; i++) {
            beadsArr[i] = sc.nextInt();
        }

        beads = Arrays.stream(beadsArr).boxed().collect(Collectors.toList());

        selectBeads(0);

        System.out.println(maxSumOfEnergy);
    }

    public static void selectBeads(int sumOfEnergy) {
        if (beads.size() == 2) {
            maxSumOfEnergy = Math.max(maxSumOfEnergy, sumOfEnergy);
            return;
        }
        for (int i = 0; i < beads.size() - 2; i++) {
            int sum = sumOfEnergy + calculateEnergy(i);
            // 에너지 구슬 제거
            Integer removedBead = beads.remove(i + 1);
            selectBeads(sum);
            // 제거된 구슬 다시 넣기
            beads.add(i + 1, removedBead);
        }
    }

    public static int calculateEnergy(int index) {
        return beads.get(index) * beads.get(index + 2);
    }
}
