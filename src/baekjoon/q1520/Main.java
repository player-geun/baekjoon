package baekjoon.q1520;

import com.sun.security.jgss.GSSUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);

        deque.addLast(deque.pop());
        System.out.println();
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>(new int[]{});
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> resultList = new ArrayList<>();
        int count = 0;
        int start = 0;
        while (start < progresses.length) {
            for (int i = start; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            for (int i = start; i < progresses.length; i++) {
                if (progresses[i] < 100) {
                    if (i != start && progresses[i - 1] == 100) {
                        resultList.add(count);
                        count = 0;
                        start = i;
                    }
                    break;
                }
                count++;
            }
        }

        return resultList.stream().mapToInt(e -> e).toArray();
    }

    private static List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }
}
