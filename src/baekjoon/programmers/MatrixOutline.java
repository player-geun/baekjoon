package baekjoon.programmers;

public class MatrixOutline {

    static int[][] matrix;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4}, {3,3,6,6}, {5,1,6,3}};

        int[] result = new int[queries.length];
        matrix = new int[6][6];

        initMatrix(rows, columns);

        int index = 0;
        for (int[] query : queries) {
            rotate(query);
            result[index++] = min;
            min = Integer.MAX_VALUE;
        }

        System.out.println();
    }

    public static void rotate(int[] queries) {
        int startY = queries[0] - 1;
        int startX = queries[1] - 1;
        int endY = queries[2] - 1;
        int endX = queries[3] - 1;

        int temp = matrix[startY][startX];
        min = Math.min(min, temp);

        for (int i = startY; i < endY; i++) {
            matrix[i][startX] = matrix[i + 1][startX];
            min = Math.min(min, matrix[i + 1][startX]);
        }

        for (int i = startX; i < endX; i++) {
            matrix[endY][i] = matrix[endY][i + 1];
            min = Math.min(min, matrix[endY][i + 1]);
        }

        for (int i = endY; i > startY; i--) {
            matrix[i][endX] = matrix[i - 1][endX];
            min = Math.min(min, matrix[i - 1][endX]);
        }

        for (int i = endX; i > startX + 1; i--) {
            matrix[startY][i] = matrix[startY][i - 1];
            min = Math.min(min, matrix[startY][i - 1]);
        }

        matrix[startY][startX + 1] = temp;
    }

    public static void initMatrix(int rows, int columns) {
        int number = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = number++;
            }
        }
    }
}
