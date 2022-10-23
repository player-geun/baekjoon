package baekjoon.review;

import java.util.Scanner;

public class Main {

    static int p, q, n;
    static Scanner sc;

    public static void main(String[] args) {
        //p,q 설정
        init();
        //공개키, 비밀키 설정
        int[] key = setKey();
        //암호화 진행 -> 공개키 사용
        int C = encrypt(key[0]);
        //복호화 진행
        int M = decrypt(key[1], C);

        System.out.println("암호화 결과: " + C);
        System.out.println("복호화 결과: " + M);
    }

    public static void init() {
        System.out.println("사용할 p, q를 선택하세요.");
        System.out.println("1: p=3, q=11");
        System.out.println("2: p=7, q=17");

        sc = new Scanner(System.in);
        int opt = sc.nextInt();

        if (opt == 1) {
            p = 3;
            q = 11;
            n = 3 * 11;
        } else if (opt == 2) {
            p = 7;
            q = 17;
            n = 7 * 17;
        } else {        //입력 예외 처리
            System.out.println("1과 2사이만 입력가능 합니다.");
            init();
        }
    }

    public static int[] setKey() {
        // 오일러 파이 Φ(n)
        int pi = (p - 1) * (q - 1);

        //e 구하기
        int e = 0;
        boolean isSet = false;

        for (int i = 2; i < pi; i++) {
            for (int j = 2; j <= i; j++) {
                if (pi % j == 0 && i % j == 0) {
                    isSet = true;
                    break;
                }
            }

            if (isSet) {
                isSet = false;
            } else {
                e = i;
                break;
            }
        }

        //d 구하기
        int[] s = {1, 0};
        int[] t = {0, 1};
        int[] r = {pi, pi % e};
        int q = pi / e;
        int d = 0;

        //확장된 유클리드 알고리즘 사용
        while (r[1] != 0) {
            int S = s[0] - q * s[1];
            int T = t[0] - q * t[1];
            q = r[0] / r[1];
            int R = r[0] % r[1];

            if (R == 0) {
                d = T;
                break;
            }

            s[0] = s[1];
            s[1] = S;
            r[0] = r[1];
            r[1] = R;
        }

        if (d < 0) {
            d += pi;
        }

        return new int[]{e, d};
    }

    public static int encrypt(int e) {
        System.out.println("암호화할 평문을 입력하세요.\n(단, 한번에 숫자 두 자리씩 입력)");
        int M = sc.nextInt();

        //예외처리
        while (M < 10 || M > 99) {
            System.out.println("2자리가 아닙니다. 다시 입력해주세요.");
            M = sc.nextInt();
        }
        //예외처리
        if (M >= n) {
            System.out.println("주어진 평문의 크기가 너무 큽니다. p, q를 다시 선택해주세요.");
            return 0;
        }

        //암호화 진행
        //나머지 연산의 성질을 이용 -> 그냥 거듭제곱하면 오버플로우 발생
        int C = M % n;
        for (int i = 1; i < e; i++) {
            C = C * M % n;
        }

        return C;
    }

    public static int decrypt(int d, int C) {
        //복호화 진행
        //나머지 연산의 성질을 이용 -> 그냥 거듭제곱하면 오버플로우 발생
        int M = C % n;
        for (int i = 1; i < d; i++) {
            M = M * C % n;
        }

        return M;
    }
}
