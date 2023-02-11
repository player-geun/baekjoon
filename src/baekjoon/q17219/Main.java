package baekjoon.q17219;

import java.util.*;

public class Main {

    static int N, M;
    static Map<String, String> passwordMap;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        passwordMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            passwordMap.put(sc.next(), sc.next());
        }

        for (int i = 0; i < M; i++) {
            System.out.println(passwordMap.get(sc.next()));
        }
    }
}
