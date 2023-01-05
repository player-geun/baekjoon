

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        search();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void search() {
        int result = 0;

        for (int i = 0; i < N - 3; i++) {
            if (arr[i] < arr[i + 1] && arr[i + 1] > arr[i + 2] && arr[i + 2] < arr[i + 3]) {
                result++;
            } else if (arr[i] > arr[i + 1] && arr[i + 1] < arr[i + 2] && arr[i + 2] > arr[i + 3]) {
                result++;
            }
        }

        System.out.println(result);
    }
}
