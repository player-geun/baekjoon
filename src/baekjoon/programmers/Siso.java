package baekjoon.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Siso {

    public long solution(int[] weights) {
        Arrays.sort(weights);
        long result = 0;
        Map<Double, Integer> map = new HashMap<>();

        for (int weight : weights) {
            double a = weight * 1.0;
            double b = weight * 2.0 / 3;
            double c = weight / 2.0;
            double d = weight * 3.0 / 4;

            if (map.containsKey(a)) {
                result += map.get(a);
            }

            if (map.containsKey(b)) {
                result += map.get(b);
            }

            if (map.containsKey(c)) {
                result += map.get(c);
            }

            if (map.containsKey(d)) {
                result += map.get(d);
            }

            map.putIfAbsent((double) weight, 0);
            map.put((double) weight, map.get((double) weight) + 1);
        }
        return result;
    }
}
