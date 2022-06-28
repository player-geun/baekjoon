package baekjoon.q10773;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Integer> stack = new ArrayList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {

            int num = in.nextInt();

            if (num == 0) {
                stack.remove(stack.size() - 1);
            } else {
                stack.add(num);
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            sum += stack.get(i);
        }

        System.out.println(sum);
    }
}
