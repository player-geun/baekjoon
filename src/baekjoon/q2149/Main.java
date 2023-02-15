package baekjoon.q2149;

import java.util.*;

public class Main {

    static String key;
    static String plaintext;
    static char[][] encodingArray;
    static Queue<char[]> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        key = sc.next();
        plaintext = sc.next();
        queue = new LinkedList<>();

        int row = key.length();
        int column = plaintext.length() / key.length() + 1;
        encodingArray = new char[row][column];

        char[] sortedKey = new char[row];
        for (int i = 0; i < row; i++) {
            sortedKey[i] = key.charAt(i);
        }

        Arrays.sort(sortedKey);

        for (int i = 0; i < row; i++) {
            encodingArray[i][0] = sortedKey[i];
        }

        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 1; j < column; j++) {
                encodingArray[i][j] = plaintext.charAt(index++);
            }
        }

        for (int i = 0; i < row; i++) {
            queue.add(encodingArray[i]);
        }

        index = 0;
        while (!queue.isEmpty()) {
            if (key.charAt(index) == queue.peek()[0]) {
                char[] now = queue.poll();
                encodingArray[index] = now;
                index++;
            } else {
                queue.add(queue.poll());
            }
        }

        for (int i = 1; i < column; i++) {
            for (int j = 0; j < row; j++) {
                sb.append(encodingArray[j][i]);
            }
        }

        System.out.println(sb);
    }
}
