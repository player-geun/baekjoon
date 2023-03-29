package baekjoon.q14225;

import java.util.*;

public class Main {

    static int N, min;
    static int[] numbers;
    static boolean[] possibleNumbers;

    public static void main(String[] args) {
        //입력
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];
        possibleNumbers = new boolean[2000001];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        // 가능한 모든 경우의 부분수열의 합을 boolean 배열을 통해 체크한다.
        allocatePossibleNumbers(0, 0);
        // 체크된 배열에서 가능하지 않은 부분 수열의 최소합을 찾아낸다.
        findMinNonPossibleNumber();

        System.out.println(min);
    }

    public static void allocatePossibleNumbers(int start, int sum) {
        //dfs -> 조합
        // 시작 인덱스를 계속 갱신함으로써 순서가 다른 쌍이 나오지 않도록 한다.
        // 1이 포함된 조합은 처음 for문을 통해서만 계산되고, 2번째 재귀부터는 1이 포함될 수가 없어 순서가 다른 쌍이 나오지 않는다.
        for (int i = start; i < N; i++) {
            int possibleSum = sum + numbers[i];
            possibleNumbers[possibleSum] = true;
            allocatePossibleNumbers(i + 1, possibleSum);
        }
    }

    public static void findMinNonPossibleNumber() {
        for (int i = 1; i < 2000001; i++) {
            if (!possibleNumbers[i]) {
                min = i;
                return;
            }
        }
    }
}
