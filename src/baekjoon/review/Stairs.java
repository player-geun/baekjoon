package baekjoon.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
알고리즘 프로그래밍 과제2
2018125039 이근우
 */
public class Stairs {

    static int N, A, B;
    static int[] stairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        stairs = new int[N + 1];

        //재귀 함수의 중간 결과를 저장하는 배열
        for (int i = 1; i < stairs.length; i++) {
            stairs[i] = 0;
        }

        //입력에 대한 예외 처리
        if (N == 1) {
            if (A == 1 || B == 1) {
                System.out.println(0);
                return;
            } else {
                System.out.println(1);
                return;
            }
        }
        if (A == 1 || B == 1) {
            if (A == 2 || B == 2) {
                System.out.println(0);
                return;
            } else {
                stairs[1] = 0;
                stairs[2] = 1;
            }
        } else if (A == 2 || B == 2) {
            stairs[1] = 1;
            stairs[2] = 0;
        } else {
            stairs[1] = 1;
            stairs[2] = 2;
        }

        if (N == A || N == B) {
            System.out.println(0);
        } else {
            //재귀 함수 시작
            int cnt = rec(N);
            if (stairs[0] == -1) {
                System.out.println(0);
            } else {
                System.out.println(cnt);
            }
        }
    }

    //재귀를 통해 거꾸로 탐색
    static int rec(int n) {
        if (n < 1) {
            return 0;
        }
        if (stairs[n] > 0) {
            return stairs[n];
        } else {
            //장애물 여부에 따라 로직을 다르게 수행
            if (n - 1 == A || n - 1 == B) {
                if (n - 2 == A || n - 2 == B) {
                    stairs[0] = -1;
                    return 0;
                } else {
                    stairs[n] = rec(n - 2);
                    return stairs[n];
                }
            } else if (n - 2 == A || n - 2 == B) {
                stairs[n] = rec(n - 1);
                return stairs[n];
            } else {
                stairs[n] = rec(n - 1) + rec(n - 2);
                return stairs[n];
            }
        }
    }
}
