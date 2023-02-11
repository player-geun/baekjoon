package baekjoon.q9375;

import java.util.*;
import java.io.*;

public class Main {

    static Map<String, Integer> fashion;
    static int T, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        while (T-- > 0) {
            n = sc.nextInt();
            fashion = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String name = sc.next();
                String type = sc.next();

                if (fashion.containsKey(type)) {
                    fashion.put(type, fashion.get(type) + 1);
                } else {
                    fashion.put(type, 1);
                }
            }


            int caseNumber = 1;
            for (int typeNumber : fashion.values()) {
                caseNumber *= (typeNumber + 1);
            }

            System.out.println(caseNumber - 1);
        }
    }
}
