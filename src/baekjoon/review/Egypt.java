package baekjoon.review;

import java.util.Scanner;

/*
알고리즘 프로그래밍 과제1
2018125039 이근우
 */
public class Egypt {

    public static void main(String[] args) {
        /*
        <입력>
        p/q를 나타내는 두 정수 p, q가 사이에 공백을 하나 두고 주어진다.
        p는 1 이상 1,000 이하, q는 p+1 이상 2,000 이하인 정수
         */
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();
        int q = sc.nextInt();

        /*
        <알고리즘>
        주어진 수 p/q의 역수 q/p와 같거나 큰 가장 작은 정수 [q/p]를 찾고
        1/[q/p]를 p/q에서 뺀는 것을 0이 될 때까지 반복
         */
        Fraction F = new Fraction(p, q);    //p/q 생성
        int cnt = 0;

        while (true) {
            Fraction I = inverse(F);        //[q/p] 생성
            Fraction R = minus(F, I);       //분모, 분자 통분하여 빼기
            cnt++;                          //나눗셈의 결과로 나오는 분수 갯수 체크

            if (R.n == 0 && R.d == 0) {
                break;                      //뺀 결과가 0이 되면 종료
            } else {
                F = R;
            }
        }

        /*
        <출력>
        수업 시간에 배운 이집트 나눗셈의 결과로 몇 개의 분수가 나오는지 출력한다.
        예를 들어, 5/6은 1/2 + 1/3이므로 2개의 분수가 필요하다.
         */
        System.out.println(cnt);
    }

    /*
    <[q/p] 만드는 함수>
    분모를 분자로 나눈 나머지가 0이면 q/p를 그대로 반환
        -> 역수의 결과가 정수이므로
    분모를 분자로 나눈 나머지가 0이 아니면 q/p + 1을 반환
        -> 역수의 결과가 정수가 아니므로 역수보다 큰 가장 작은 정수 생성
     */
    static Fraction inverse(Fraction F) {
        if (F.d % F.n == 0) {
            return new Fraction(1, F.d / F.n);
        } else {
            return new Fraction(1, F.d / F.n + 1);
        }
    }

    /*
    <분수끼리 뺄샘해주는 함수>
    각각의 수를 통분하여 뺄샘
    이때 통분한 분자의 뺄셈 결과가 0인 경우, 분모와 분자에 모두 0 설정
     */
    static Fraction minus(Fraction F, Fraction I) {
        int newD = F.d * I.d;       //새로운 F와 I의 분모
        int newFn = F.n * I.d;      //새로운 F의 분자
        int newIn = I.n * F.d;      //새로운 I의 분자

        if (newFn - newIn == 0) {
            return new Fraction(0, 0);
        } else {
            return new Fraction(newFn - newIn, newD);
        }
    }

    /*
    <분수 클래스>
    분모와 분자를 각각 속성으로 가지고 있는 분수 클래스
    생성자를 통해 값을 초기화 및 설정
     */
    private static class Fraction {

        int n = 0;  //분자
        int d = 0;  //분모

        Fraction(int n, int d) {
            this.n = n;
            this.d = d;
        }
    }
}
