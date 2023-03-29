package baekjoon.programmers;

public class ThreeRadix {

    public static void main(String[] args) {
        int n = 45;
        StringBuilder sb = new StringBuilder();

        String reverse = sb.append(Integer.toString(n, 3)).reverse().toString();

        System.out.println(Integer.parseInt(reverse, 3));
    }
}
