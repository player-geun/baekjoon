package baekjoon.q2659;

import java.util.*;

public class Main {

    static int clockNumber;
    static HashSet<Integer> clockNumbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        clockNumbers = new HashSet<>();
        int first = sc.nextInt() * 1000;
        int second = sc.nextInt() * 100;
        int third = sc.nextInt() * 10;
        int fourth = sc.nextInt();

        clockNumber = first + second + third + fourth;

        for (int i = 1111; i <= clockNumber; i++) {
            if (isZero(String.valueOf(i))) {
                continue;
            }
            clockNumbers.add(calculateMinClockNumber(i));
        }

        ArrayList<Integer> clockNumbersList = new ArrayList<>(clockNumbers);

        Collections.sort(clockNumbersList);

        for (int i = 0; i < clockNumbersList.size(); i++) {
            if (isSameClockNumber(clockNumbersList.get(i))) {
                System.out.println(i + 1);
            }
        }
    }

    public static boolean isSameClockNumber(int number) {
        Queue<Integer> list = new LinkedList<>();
        ArrayList<Integer> completeList = new ArrayList<>();
        String stringNumber = String.valueOf(number);
        for (int i = 0; i < 4; i++) {
            list.add(stringNumber.charAt(i) - '1' + 1);
        }

        for (int i = 0; i < 4; i++) {
            int sum = 0;
            int digit = 1000;
            for (int num : list) {
                sum += num * digit;
                digit /= 10;
            }

            completeList.add(sum);
            list.add(list.poll());
        }

        if (completeList.contains((Integer) clockNumber)) {
            return true;
        }

        return false;
    }

    public static boolean isZero(String number) {
        if (number.charAt(0) == '0' || number.charAt(1) == '0' || number.charAt(2) == '0' || number.charAt(3) == '0') {
            return true;
        }

        return false;
    }

    public static int calculateMinClockNumber(int number) {
        Queue<Integer> list = new LinkedList<>();
        String stringNumber = String.valueOf(number);
        int minClockNumber = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            list.add(stringNumber.charAt(i) - '1' + 1);
        }

        for (int i = 0; i < 4; i++) {
            int sum = 0;
            int digit = 1000;
            for (int num : list) {
                sum += num * digit;
                digit /= 10;
            }

            minClockNumber = Math.min(minClockNumber, sum);
            list.add(list.poll());
        }

        return minClockNumber;
    }
}
