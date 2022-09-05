package baekjoon.q1244;

import java.util.Scanner;

public class Main {

    static int[] S;
    static int A, B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        S = new int[A + 1];

        for (int i = 1; i < A + 1; i++) {
            S[i] = sc.nextInt();
        }

        B = sc.nextInt();

        for (int i = 0; i < B; i++) {
            int sex = sc.nextInt();
            int num = sc.nextInt();

            if (sex == 1) {
                int temp = num;
                while (num <= A) {
                    swap(num);
                    num += temp;
                }
            } else {
                woman(num);
            }
        }

        for (int i = 1; i < A + 1; i++) {
            System.out.print(S[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }

    static void woman(int num) {
        int middle = num;
        int a = num - 1;
        int b = num + 1;

        while (true) {
            if (a <= 0 || b > A) {
                swap(middle);
                break;
            }

            if (S[a] != S[b]) {
                while (++a != middle) {
                    b--;
                    swap(a);
                    swap(b);
                }
                swap(middle);
                break;
            } else {
                a--;
                b++;
                if (a <= 0 || b > A) {
                    while (++a != middle) {
                        b--;
                        swap(a);
                        swap(b);
                    }
                    swap(middle);
                    break;
                }
            }
        }
    }

    static void swap(int a) {
        if (S[a] == 1) {
            S[a] = 0;
        } else {
            S[a] = 1;
        }
    }
}
