package baekjoon.q2477;

import java.util.*;

public class Main {

    static int k, maxHeight, maxWidth, maxHeightIndex, maxWidthIndex;
    static int[] sidesOfHex;

    public static void main(String[] args) {
        // 입력 받기: 가로 , 세로 최대값 찾기
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        sidesOfHex = new int[6];

        for (int i = 0; i < 6; i++) {
            int direction = sc.nextInt();
            sidesOfHex[i] = sc.nextInt();

            if (direction == 1 || direction == 2) {
                if (maxWidth < sidesOfHex[i]) {
                    maxWidth = sidesOfHex[i];
                    maxWidthIndex = i;
                }
            } else {
                if (maxHeight < sidesOfHex[i]) {
                    maxHeight = sidesOfHex[i];
                    maxHeightIndex = i;
                }
            }
        }

        findSmallRectangle();
    }

    public static void findSmallRectangle() {
        int right, left = 0;
        if (maxWidthIndex + 1 == 6) {
            left = 0;
        } else {
            left = maxWidthIndex + 1;
        }

        if (maxWidthIndex - 1 == -1) {
            right = 5;
        } else {
            right = maxWidthIndex - 1;
        }

        int smallHeight = Math.abs(sidesOfHex[left] - sidesOfHex[right]);

        int up, down = 0;
        if (maxHeightIndex + 1 == 6) {
            up = 0;
        } else {
            up = maxHeightIndex + 1;
        }

        if (maxHeightIndex - 1 == -1) {
            down = 5;
        } else {
            down = maxHeightIndex - 1;
        }

        int smallWidth = Math.abs(sidesOfHex[up] - sidesOfHex[down]);

        System.out.println((maxHeight * maxWidth - smallWidth * smallHeight) * k);
    }
}
