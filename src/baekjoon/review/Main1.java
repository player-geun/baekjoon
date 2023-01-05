

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1 {

    static int K, M;
    static int[] place;
    static Car[] cars;

    public static void main(String[] args) throws IOException {
        input();
        search();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        place = new int[K];
        cars = new Car[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            place[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            cars[i] = new Car(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }

    public static void search() {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(place);
        int result = 0;

        for (Car car : cars) {
            for (int i = 0; i < place.length; i++) {
                if (car.p - car.w <= place[i] && car.p + car.w >= place[i]) {
                    result++;
                }
            }
            sb.append(result).append("\n");
            result = 0;
        }

        System.out.println(sb);
    }

    static class Car {
        private int p;
        private int w;

        public Car(int p, int w) {
            this.p = p;
            this.w = w;
        }
    }
}
