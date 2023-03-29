package baekjoon.q2630;

import java.util.*;
import java.io.*;

public class Main {

    static int[][] colorPaper;
    static final int BLUE = 1;
    static final int WHITE = 0;
    static int N, countOfWhitePapers, countOfBluePapers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        colorPaper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                colorPaper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideColorPaper(0 , 0, N - 1, N - 1);

        System.out.println(countOfWhitePapers);
        System.out.println(countOfBluePapers);
    }

    public static void divideColorPaper(int startY, int startX, int endY, int endX) {
        if (isSameColor(startY, startX, endY, endX)) {
            if (colorPaper[startY][startX] == WHITE) {
                countOfWhitePapers++;
                return;
            }

            if(colorPaper[startY][startX] == BLUE) {
                countOfBluePapers++;
                return;
            }
        }

        divideColorPaper(startY, startX, (endY + startY) / 2, (endX + startX) / 2);
        divideColorPaper(startY, (startX + endX) / 2 + 1, (endY + startY) / 2, endX);
        divideColorPaper((startY + endY) / 2 + 1, startX, endY, (endX + startX) / 2);
        divideColorPaper((startY + endY) / 2 + 1, (startX + endX) / 2 + 1, endY, endX);
    }

    public static boolean isSameColor(int startY, int startX, int endY, int endX) {
        int currentColor = colorPaper[startY][startX];
        for (int i = startY; i <= endY; i++) {
            for (int j = startX; j <= endX; j++) {
                if (currentColor != colorPaper[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
