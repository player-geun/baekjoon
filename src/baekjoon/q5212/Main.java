package baekjoon.q5212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static String[][] pos;
    static int R, C;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        pos = new String[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                pos[i][j] = line.substring(j, j + 1);
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (pos[i][j].equals("X")) {
                    int num = 0;

                    for (int k = 0; k < 4; k++) {
                        if (i + dx[k] < 0 || i + dx[k] >= R || j + dy[k] < 0 || j + dy[k] >= C) {
                            num++;
                        }else{
                            String temp = pos[i + dx[k]][j + dy[k]];

                            if (temp.equals(".")) {
                                num++;
                            }
                        }
                    }

                    if (num == 3 || num == 4) {
                        queue.add(new int[]{i, j});
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            pos[now[0]][now[1]] = ".";
        }

        int maxX = 0;
        int maxY = 0;
        int minX = 11;
        int minY = 11;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (pos[i][j].equals("X")) {
                    if (maxX < i) {
                        maxX = i;
                    }

                    if (minX > i) {
                        minX = i;
                    }

                    if (maxY < j) {
                        maxY = j;
                    }

                    if (minY > j) {
                        minY = j;
                    }
                }
            }
        }

        for (int i = minX; i < maxX + 1; i++) {
            for (int j = minY; j < maxY + 1; j++) {
                System.out.print(pos[i][j]);
            }

            System.out.println();
        }
    }
}
