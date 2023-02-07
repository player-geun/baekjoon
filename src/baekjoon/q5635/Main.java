package baekjoon.q5635;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n;
    static Classmate[] classmates;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        classmates = new Classmate[n];

        for (int i = 0; i < n; i++) {
            classmates[i] = new Classmate(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(classmates);

        System.out.println(classmates[classmates.length - 1].name);
        System.out.println(classmates[0].name);
    }

    public static class Classmate implements Comparable<Classmate> {

        private String name;
        private int month;
        private int day;
        private int year;

        public Classmate(String name,  int day, int month, int year) {
            this.name = name;
            this.month = month;
            this.day = day;
            this.year = year;
        }

        @Override
        public int compareTo(Classmate o) {
            if (this.year == o.year && this.month == o.month) {
                return this.day - o.day;
            } else if (this.year == o.year) {
                return this.month - o.month;
            } else {
                return this.year - o.year;
            }
        }
    }
}
