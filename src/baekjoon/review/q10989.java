package baekjoon.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q10989 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int []A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        radixSort(A, 5);

        for (int a : A) {
            sb.append(a).append("\n");
        }

        System.out.println(sb);
    }

    public static void radixSort(int[] A, int maxSize) {

        int[] output = new int[A.length];
        int cipher = 1;
        int count = 0;      // maxSize(입력 가능한 최대 자릿수)

        while (count != maxSize) {
            int[] bucket = new int[10];

            // bucket에 자릿수 기준(1의 자리부터 시작)으로 (0~9, bucket의 인덱스를 의미) 데이터의 개수 저장
            for (int i = 0; i < A.length; i++) {
                bucket[A[i] / cipher % 10]++;
            }

            // bucket을 누적합 배열으로 만들어 이후 output에 해당되는 index를 구하는 용도로 사용
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }

            for (int i = A.length - 1; i >= 0; i--) {
                // bucket의 누적합에서 -1을 하면 현재 자신을 제외하고 자기 앞에 있는 데이터의 개수를 의미 = output에서 인덱스
                output[bucket[A[i] / cipher % 10] - 1] = A[i];
                bucket[A[i] / cipher % 10]--;       // 배열안의 중복된 수를 위해(2, 2 와 같이 같은 수가 두번이상 포함되는 경우)
            }

            // 다음 자릿수 이동전에 현재 자릿수 기준 정렬 데이터를 저장
            for (int i = 0; i < A.length; i++) {
                A[i] = output[i];
            }

            cipher *= 10;
            count++;
        }
    }
}
