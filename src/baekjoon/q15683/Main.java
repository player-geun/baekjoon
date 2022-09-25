package baekjoon.q15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] pos = new int[N][M];
        ArrayList<CCTV> cctv = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                pos[i][j] = Integer.parseInt(st.nextToken());

                if (pos[i][j] != 0 && pos[i][j] != 6) {
                    cctv.add(new CCTV(pos[i][j], i, j));
                }
            }
        }

        dfs(0, pos, cctv);

        System.out.println(MIN);
    }

    public static void dfs(int level, int[][] pos, ArrayList<CCTV> cctv) {
        if (level == cctv.size()) {
            MIN = Math.min(MIN, checkZero(pos));
            return;
        }

        int type = cctv.get(level).type;
        int x = cctv.get(level).x;
        int y = cctv.get(level).y;
        int[][] tmp;

        if(type == 1) {
            tmp = copyPos(pos);
            checkLeft(tmp, x, y);
            dfs(level+1, tmp, cctv);

            tmp = copyPos(pos);
            checkRight(tmp, x, y);
            dfs(level+1, tmp, cctv);

            tmp = copyPos(pos);
            checkDown(tmp, x, y);
            dfs(level+1, tmp, cctv);

            tmp = copyPos(pos);
            checkUp(tmp, x, y);
            dfs(level+1, tmp, cctv);
        } else if (type == 2) {
            tmp = copyPos(pos);
            checkLeft(tmp, x, y);
            checkRight(tmp, x, y);
            dfs(level+1, tmp, cctv);

            tmp = copyPos(pos);
            checkUp(tmp, x, y);
            checkDown(tmp, x, y);
            dfs(level+1, tmp, cctv);
        } else if (type == 3) {
            tmp = copyPos(pos);
            checkLeft(tmp, x, y);
            checkUp(tmp, x, y);
            dfs(level+1, tmp, cctv);

            tmp = copyPos(pos);
            checkUp(tmp, x, y);
            checkRight(tmp, x, y);
            dfs(level+1, tmp, cctv);

            tmp = copyPos(pos);
            checkRight(tmp, x, y);
            checkDown(tmp, x, y);
            dfs(level+1, tmp, cctv);

            tmp = copyPos(pos);
            checkDown(tmp, x, y);
            checkLeft(tmp, x, y);
            dfs(level+1, tmp, cctv);
        } else if(type == 4) {
            tmp = copyPos(pos);
            checkLeft(tmp, x, y);
            checkUp(tmp, x, y);
            checkRight(tmp, x, y);
            dfs(level+1, tmp, cctv);

            tmp = copyPos(pos);
            checkUp(tmp, x, y);
            checkRight(tmp, x, y);
            checkDown(tmp, x, y);
            dfs(level+1, tmp, cctv);

            tmp = copyPos(pos);
            checkRight(tmp, x, y);
            checkDown(tmp, x, y);
            checkLeft(tmp ,x , y);
            dfs(level+1, tmp, cctv);

            tmp = copyPos(pos);
            checkDown(tmp, x, y);
            checkLeft(tmp ,x , y);
            checkUp(tmp, x, y);
            dfs(level+1, tmp, cctv);
        } else if(type == 5) {
            tmp = copyPos(pos);
            checkRight(tmp, x, y);
            checkDown(tmp, x, y);
            checkLeft(tmp ,x , y);
            checkUp(tmp, x, y);
            dfs(level+1, tmp, cctv);
        }
    }

    public static int checkZero(int[][] pos) {
        int zero = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(pos[i][j] == 0){
                    zero++;
                }
            }
        }
        return zero;
    }

    public static void checkLeft(int[][] pos, int x, int y) {
        for(int i=y-1; i>=0; i--) {
            if(pos[x][i] == 6) return;
            if(pos[x][i] != 0) continue;
            pos[x][i] = -1;
        }
    }

    public static void checkRight(int[][] pos, int x, int y) {
        for(int i=y+1; i<M; i++) {
            if(pos[x][i] == 6) return;
            if(pos[x][i] != 0) continue;
            pos[x][i] = -1;
        }
    }

    public static void checkUp(int[][] map, int x, int y) {
        for(int i=x-1; i>=0; i--) {
            if(map[i][y] == 6) return;
            if(map[i][y] != 0) continue;
            map[i][y] = -1;
        }
    }

    public static void checkDown(int[][] map, int x, int y) {
        for(int i=x+1; i<N; i++) {
            if(map[i][y] == 6) return;
            if(map[i][y] != 0) continue;
            map[i][y] = -1;
        }
    }

    public static int[][] copyPos(int[][] map) {
        int[][]tmp = new int[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        return tmp;
    }

    static class CCTV {
        int type;
        int x;
        int y;

        public CCTV(int type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }
}
