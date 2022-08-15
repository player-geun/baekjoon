package baekjoon.q2841;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int P = sc.nextInt();
        int result = 0;

        ArrayList<ArrayList<Integer>> A = new ArrayList<>();

        for (int i = 0; i < 500001; i++) {
            A.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (!A.get(a).isEmpty()) {
                while (true) {
                    if (A.get(a).isEmpty()) {
                        A.get(a).add(b);
                        result++;
                        break;
                    }
                    else if (A.get(a).get(A.get(a).size() - 1) > b) {
                        A.get(a).remove(A.get(a).size() - 1);
                        result++;
                    } else if (A.get(a).get(A.get(a).size() - 1) == b) {
                        break;
                    } else {
                        A.get(a).add(b);
                        result++;
                        break;
                    }
                }
            } else {
                A.get(a).add(b);
                result++;
            }
        }

        System.out.println(result);
    }

}
