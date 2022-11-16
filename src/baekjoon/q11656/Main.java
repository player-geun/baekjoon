package baekjoon.q11656;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        char[] list = word.toCharArray();
        String[] array = new String[word.length()];

        for (int i = 0; i < list.length; i++) {
            char[] temp = new char[list.length - i];
            for (int j = i; j < list.length; j++) {
                temp[j - i] = list[j];
            }
            array[i] = String.valueOf(temp);
        }

        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (String a : array) {
            System.out.println(a);
        }
    }
}
