package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();

        a.add(new ArrayList<>());
        a.add(new ArrayList<>());

        a.get(1).add(1);

        System.out.println(a.get(1).remove((Integer) 2));
    }
}
