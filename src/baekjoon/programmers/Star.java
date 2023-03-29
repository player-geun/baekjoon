package baekjoon.programmers;

import java.util.*;

public class Star {

    static List<double[]> integerCrossPoints;

    public static void main(String[] args) {
        int[][] line = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
        integerCrossPoints = new ArrayList<>();

        DFS(line, 1);
        int[] rectangle = findRectangle();

        int row = rectangle[1] - rectangle[3] + 1;
        int column = rectangle[0] - rectangle[2] + 1;

        char[][] newBoard = new char[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                newBoard[i][j] = '.';
            }
        }

        drawStar(newBoard, rectangle[2], rectangle[1]);

        StringBuilder sb = new StringBuilder();
        String[] result = new String[row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                sb.append(newBoard[i][j]);
            }
            result[i] = sb.toString();
            sb.setLength(0);
        }
    }

    public static void drawStar(char[][] newBoard, int minX, int maxY) {
        for (double[] crossPoint : integerCrossPoints) {
            int newX = (int) crossPoint[0] + Math.abs(minX);
            int newY = maxY - (int) crossPoint[1];

            newBoard[newY][newX] = '*';
        }
    }

    public static int[] findRectangle() {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (double[] crossPoint : integerCrossPoints) {
            maxX = Math.max(maxX, (int) crossPoint[0]);
            maxY = Math.max(maxY, (int) crossPoint[1]);
            minX = Math.min(minX, (int) crossPoint[0]);
            minY = Math.min(minY, (int) crossPoint[1]);
        }

        return new int[]{maxX, maxY, minX, minY};
    }

    public static void DFS(int[][] line, int start) {

        if (start == line.length) {
            return;
        }

        int[] startLine = line[start - 1];

        for (int i = start; i < line.length; i++) {
            double[] crossPoint = calculateCrossPoint(startLine, line[i]);

            if (validateInteger(crossPoint)) {
                integerCrossPoints.add(crossPoint);
            }
        }

        DFS(line, start + 1);
    }

    public static boolean validateInteger(double[] crossPoint) {
        if (crossPoint[0] != Math.floor(crossPoint[0])) {
            return false;
        }

        if (crossPoint[1] != Math.floor(crossPoint[1])) {
            return false;
        }

        return true;
    }

    public static double[] calculateCrossPoint(int[] startLine, int[] otherLine) {
        long temp1 = startLine[1] * otherLine[2] - startLine[2] * otherLine[1];
        long temp2 = startLine[0] * otherLine[1] - startLine[1] * otherLine[0];
        double x = (double) temp1 / temp2;

        temp1 = startLine[2] * otherLine[0] - startLine[0] * otherLine[2];
        temp2 = startLine[0] * otherLine[1] - startLine[1] * otherLine[0];
        double y = (double) temp1 / temp2;

        return new double[]{x, y};
    }
}
