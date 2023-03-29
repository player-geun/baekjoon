package baekjoon.q18428;

import java.util.*;
import java.util.stream.*;

public class Main {

    static int N;
    static boolean possible;
    static char[][] hallways;
    static ArrayList<int[]> selectedHallways;
    static ArrayList<int[]> positionOfTeachers;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        hallways = new char[N][N];
        selectedHallways = new ArrayList<>();
        positionOfTeachers = new ArrayList<>();

        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] lines = line.split(" ");
            for (int j = 0; j < N; j++) {
                hallways[i][j] = lines[j].charAt(0);
                if (hallways[i][j] == 'T') {
                    positionOfTeachers.add(new int[]{i, j});
                }
            }
        }

        selectThreeHallway(0);

        System.out.println(possible ? "YES" : "NO");

    }

    public static void selectThreeHallway(int start) {
        if (selectedHallways.size() == 3) {
            if (!isPossiblePoint()) {
                return;
            }
            // 3점의 장애물에 대해 감시에 대한 결과 도출
            if (checkStudentInHallways()) {
                possible = true;
            }
            removeThreeObstacles();
            return;
        }

        for (int i = start; i < N * N; i++) {
            selectedHallways.add(changePointToTwoDimension(i));
            selectThreeHallway(i + 1);
            selectedHallways.remove(selectedHallways.size() - 1);
        }
    }

    public static int[] changePointToTwoDimension(int index) {
        return new int[]{index / N, index % N};
    }

    public static boolean checkStudentInHallways() {
        addThreeObstacles();

        for (int[] teacher : positionOfTeachers) {
            for (int i = 0; i < 4; i++) {
                int y = teacher[0];
                int x = teacher[1];

                while (true) {
                    y += dy[i];
                    x += dx[i];

                    if (y < 0 || y >= N || x < 0 || x >= N) {
                        break;
                    }

                    if (hallways[y][x] == 'S') {
                        return false;
                    }

                    if (hallways[y][x] == 'O') {
                        break;
                    }
                }
            }
        }

        return true;
    }

    public static boolean isPossiblePoint() {
        for (int[] now : selectedHallways) {
            if (hallways[now[0]][now[1]] != 'X') {
                return false;
            }
        }

        return true;
    }

    public static void addThreeObstacles() {
        for (int[] now : selectedHallways) {
            hallways[now[0]][now[1]] = 'O';
        }
    }

    public static void removeThreeObstacles() {
        for (int[] now : selectedHallways) {
            hallways[now[0]][now[1]] = 'X';
        }
    }
}
