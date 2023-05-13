package baekjoon;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        String a = "abc";

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        for (int i = 0; i < 3; i++) {
            Collections.shuffle(list);
            System.out.println(list);
        }
    }
}
