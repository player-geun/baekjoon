package baekjoon.q4673;

public class Main {

    static boolean[] numArray = new boolean[10001];

    public static void main(String[] args) {

        for (int i = 1; i < 10001; i++) {
            for (int j = 1; j < i; j++) {
                int sum = j;
                int d = j;

                while (d > 0) {
                    sum += (d % 10);
                    d /= 10;
                }

                if (i == sum) {
                    numArray[i] = true;
                    break;
                }
            }
        }

        for (int i = 1; i < 10001; i++) {
            if (!numArray[i]) {
                System.out.println(i);
            }
        }
    }
}
