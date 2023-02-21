package baekjoon.q15970;

import java.util.*;

public class Main {

    static int N, sum;
    static ArrayList<Integer>[] indexOfColors;   // 행: 색깔, 열: 점의 위치

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        indexOfColors = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            indexOfColors[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int index = sc.nextInt();
            int color = sc.nextInt();

            indexOfColors[color].add(index);
        }

        calculateSum();

        System.out.println(sum);
    }

    public static void calculateSum() {
        for (int i = 0; i <= N; i++) {
            Collections.sort(indexOfColors[i]);
            for (int j = 0; j < indexOfColors[i].size(); j++) {
                if (j == 0) {
                    sum += indexOfColors[i].get(j + 1) - indexOfColors[i].get(j);
                } else if (j == indexOfColors[i].size() - 1) {
                    sum += indexOfColors[i].get(j) - indexOfColors[i].get(j - 1);
                } else {
                    if (indexOfColors[i].get(j + 1) - indexOfColors[i].get(j)
                            < indexOfColors[i].get(j) - indexOfColors[i].get(j - 1)) {
                        sum += indexOfColors[i].get(j + 1) - indexOfColors[i].get(j);
                    } else {
                        sum += indexOfColors[i].get(j) - indexOfColors[i].get(j - 1);
                    }
                }
            }
        }
    }
}
