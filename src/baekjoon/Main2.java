package baekjoon;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        String a = "abc";

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        for (int b : list.toArray(new Integer[0])) {
            System.out.println(b);
        }

        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MAX));
    }
}
