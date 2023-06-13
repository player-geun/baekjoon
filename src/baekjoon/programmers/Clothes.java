package baekjoon.programmers;

import java.util.HashMap;
import java.util.Map;

public class Clothes {

    public int solution(String[][] clothes) {
        Map<String, Integer> clothMap = toMap(clothes);

        int result = 1;
        for (String kind : clothMap.keySet()) {
            result *= clothMap.get(kind);
        }
        return result - 1;
    }

    private Map<String, Integer> toMap(String[][] clothes) {
        Map<String, Integer> clothMap = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            clothMap.putIfAbsent(clothes[i][1], 1);
            clothMap.put(clothes[i][1], clothMap.get(clothes[i][1]) + 1);
        }
        return clothMap;
    }
}
