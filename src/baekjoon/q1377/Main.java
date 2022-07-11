package baekjoon.q1377;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Data[] A = new Data[N];

        for (int i = 0; i < N; i++) {
            A[i] = new Data( Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(A);     //value 기준으로 오름차순 정렬을 해주기 위해 comparable 인터페이스 사용

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < A[i].index - i) {
                max = A[i].index - i;
            }
        }

        System.out.println(max + 1);
    }

    static class  Data implements Comparable<Data> {

        int value;
        int index;

        public Data(int value, int index) {
            super();
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Data o) {
            return this.value - o.value;
        }
    }
}
