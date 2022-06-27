package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    private static ArrayList<Integer> stack = new ArrayList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {

            String str = in.next();

            switch (str) {

                case "push":
                    stack.add(in.nextInt());
                    break;

                case "pop":
                    if (stack.isEmpty()) {
                        sb.append("-1").append("\n");
                    }else{
                        sb.append(stack.remove(stack.size() - 1)).append("\n");
                    }
                    break;

                case "size":
                    sb.append(stack.size()).append("\n");
                    break;

                case "empty":
                    if (stack.isEmpty()) {
                        sb.append("1").append("\n");
                    }else{
                        sb.append("0").append("\n");
                    }
                    break;

                case "top":
                    if (stack.isEmpty()) {
                        sb.append("-1").append("\n");
                    }else {
                        sb.append(stack.get(stack.size() - 1)).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}