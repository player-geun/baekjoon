package baekjoon.q1620;

import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static Map<String, Integer> poketmonNameDictionary;
    static Map<String, String> poketmonIndexDictionary;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        poketmonNameDictionary = new HashMap<>();
        poketmonIndexDictionary = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = sc.next();
            poketmonNameDictionary.put(name, i);
            poketmonIndexDictionary.put(String.valueOf(i), name);
        }

        for (int i = 0; i < M; i++) {
            String input = sc.next();
            if (poketmonNameDictionary.containsKey(input)) {
                System.out.println(findPoketmonIndex(input));
            } else {
                System.out.println(findPoketmonName(input));
            }
        }
    }

    public static int findPoketmonIndex(String name) {
        return poketmonNameDictionary.get(name);
    }

    public static String findPoketmonName(String index) {
        return poketmonIndexDictionary.get(index);
    }
}
