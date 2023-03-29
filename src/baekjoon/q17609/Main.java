package baekjoon.q17609;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static Deque<Character> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            deque = new LinkedList<>(str.chars().mapToObj(e -> (char) e).collect(Collectors.toList()));

            if (validatePalindrome(deque)) {
                System.out.println(0);
                continue;
            } else {
                if (validateSimilar()) {
                    System.out.println(1);
                    continue;
                }

                System.out.println(2);
            }
        }
    }

    public static boolean validatePalindrome(Deque<Character> deque) {
        while (deque.size() > 1) {
            if (deque.peekFirst() != deque.peekLast()) {
                return false;
            } else {
                deque.removeLast();
                deque.removeFirst();
            }
        }

        return true;
    }

    public static boolean validateSimilar() {
        Deque<Character> copy = new LinkedList<>(deque);

        deque.removeLast();
        boolean last = validatePalindrome(deque);

        copy.removeFirst();
        boolean first = validatePalindrome(copy);

        if (last || first) {
            return true;
        }

        return false;
    }
}