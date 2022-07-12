package baekjoon.q2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[] arr, tmp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        tmp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(1, N);

        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void mergeSort(int s, int e) {

        if (e - s < 1) {
            return;
        }

        int m = s + (e - s) / 2;
        // 재귀함수로 구현
        mergeSort(s, m);
        mergeSort(m + 1, e);

        for (int i = s; i <= e; i++) {
            tmp[i] = arr[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m + 1;

        // 두 그룹을 병합하는 로직
        while (index1 <= m && index2 <= e) {
            if (tmp[index1] > tmp[index2]) {
                arr[k] = tmp[index2];
                k++;
                index2++;
            } else {
                arr[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        // 한쪽 그룹이 모두 선택된 후 남아 있는 값 정리하기
        while (index1 <= m) {
            arr[k] = tmp[index1];
            k++;
            index1++;
        }
        while (index2 <= e) {
            arr[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
