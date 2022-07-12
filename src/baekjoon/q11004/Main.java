package baekjoon.q11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // N의 크기가 5,000,000 이기 때문에 NlogN 을 사용해도 시간이 촉박하여 Scanner 대신 BufferReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N : 정렬할 배열의 크기   k : 정렬된 배열에서 탐색해야할 아이템의 인덱스
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(arr, 0, N - 1, K - 1);
        System.out.println(arr[K - 1]);
    }

    public static void quickSort(int[] arr, int S, int E, int K) {

        if (S < E) {
            int pivot = partition(arr, S, E);

            if (pivot == K) {
                return;
            } else if (K < pivot) {
                quickSort(arr, S, pivot - 1, K);
            } else {
                quickSort(arr, pivot + 1, E, K);
            }
        }
    }

    private static int partition(int[] A, int S, int E){
        if(S+1==E) {
            if(A[S]>A[E])swap(A,S,E);
            return E;
        }
        int M = (S + E) / 2;
        swap(A, S, M); // 중앙값을 1번째 요소로 이동하기
        int pivot = A[S];
        int i = S+1, j = E;

        while (i <= j) {
            while (pivot < A[j] && j > 0 ){   //피벗보다 작은 수가 나올때까지 j--
                j--;
            }
            while (pivot > A[i]  && i <A.length-1){  //피벗보다 큰 수가 나올 떄까지 i++
                i ++;
            }
            if (i <= j) {
                swap (A, i++, j--);  // 찾은 i와 j를 교환하기
            }
        }
        // i == j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정하기
        A[S] = A[j];
        A[j] = pivot;
        return j;
    }

    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
