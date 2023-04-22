package baekjoon.q18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = removeDuplication(input);

        List<Integer> list = sort(set);

        Map<Integer, Integer> map = makeOrderedPairs(set, list);

        for (int number : input) {
            sb.append(map.get(number)).append(" ");
        }

        System.out.println(sb);
    }

    private static Map<Integer, Integer> makeOrderedPairs(Set<Integer> set, List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < set.size(); i++) {
            map.put(list.get(i), i);
        }
        return map;
    }

    private static List<Integer> sort(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    private static Set<Integer> removeDuplication(int[] input) {
        Set<Integer> set = new HashSet<>();
        for (int number : input) {
            set.add(number);
        }
        return set;
    }
}
