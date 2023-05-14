package baekjoon.q13414;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int L = sc.nextInt();

        List<String> waitingLine = new ArrayList<>();
        for (int i = 0; i < L; i++) {
            waitingLine.add(sc.next());
        }

        boolean[] checked = new boolean[100000000];
        for (int i = 0; i < L; i++) {
            String studentNumber = waitingLine.get(i);
            int number = Integer.parseInt(studentNumber);

            if (!checked[number]) {
                checked[number] = true;
            } else {
                checked[number] = false;
                waitingLine.remove(studentNumber);
                waitingLine.add(studentNumber);
                i--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            sb.append(waitingLine.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
