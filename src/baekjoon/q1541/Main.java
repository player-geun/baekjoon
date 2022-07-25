package baekjoon.q1541;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] arr = str.split("-");
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            int temp = mySum(arr[i]);

            if (i == 0) {
                result += temp;
            } else {
                result -= temp;
            }
        }

        System.out.println(result);
    }

    static int mySum(String a) {

        int sum = 0;
        String[] temp = a.split("[+]");

        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }

        return sum;
    }
}
