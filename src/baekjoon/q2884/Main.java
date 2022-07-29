package baekjoon.q2884;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int minute = sc.nextInt();

        if (hour == 0 && minute < 45) {
            hour = 23;
            minute = minute - 45 + 60;
        } else {
            if (minute < 45) {
                hour -= 1;
                minute = minute - 45 + 60;
            } else {
                minute = minute - 45;
            }
        }

        System.out.println(hour + " " + minute);
    }
}
