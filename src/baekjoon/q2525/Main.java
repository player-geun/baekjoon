package baekjoon.q2525;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int minute = sc.nextInt();
        int time = sc.nextInt();

        int h = time / 60;
        int m = time % 60;

        if (minute + m >= 60) {
            if (hour + h >= 23) {
                hour = hour + h + 1 - 24;
                minute = minute + m - 60;
            } else {
                hour += h + 1;
                minute = minute + m - 60;
            }
        } else {
            if (hour + h >= 24) {
                hour = hour + h - 24;
                minute = minute + m;
            } else {
                hour += h;
                minute = minute + m;
            }
        }

        System.out.println(hour + " " + minute);
    }
}
