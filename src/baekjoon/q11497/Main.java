package baekjoon.q11497;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int minLevel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<Integer> deque = new LinkedList<>();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                list.add(Integer.valueOf(st.nextToken()));
            }

            Collections.sort(list);

            addDeque(list, deque);
            calculateMinLevel(deque);

            System.out.println(minLevel);
        }
    }

    public static void calculateMinLevel(Deque<Integer> deque) {
        int lastNum = 0;
        minLevel = Math.abs(deque.getFirst() - deque.getLast());

        for (int num : deque) {
            if (lastNum == 0) {
                lastNum = num;
            } else {
                minLevel = Math.max(minLevel, Math.abs(num - lastNum));
                lastNum = num;
            }
        }
    }

    public static void addDeque(List<Integer> list, Deque<Integer> deque) {
        int index = list.size() - 1;

        while (deque.size() != list.size()) {
            if (index % 2 == 0) {
                deque.addFirst(list.get(index--));
            } else {
                deque.addLast(list.get(index--));
            }
        }
    }
}
