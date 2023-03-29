package baekjoon.q10158;

import java.util.*;
import java.io.*;

public class Main {

    private static int time;
    private static int dx, dy, cx, cy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());
        dx = 1;
        dy = 1;
        cx = x;
        cy = y;

        while (time != t) {
            goStraight(w, h, t);
            changeDirection(w, h);
        }

        System.out.println(cx + " " + cy);
    }

    public static void goStraight(int w, int h, int t) {
        int difX, difY;
        if (dx > 0) {
            difX = Math.abs(cx - w);
        } else {
            difX = Math.abs(cx);
        }

        if (dy > 0) {
            difY = Math.abs(cy - h);
        } else {
            difY = Math.abs(cy);
        }

        if (difX > difY) {
            if (t - time < difY) {
                difY = t - time;
            }
            cy = cy + difY * dy;
            cx = cx + difY * dx;
            time += difY;
        } else {
            if (t - time < difX) {
                difX = t - time;
            }
            cy = cy + difX * dy;
            cx = cx + difX * dx;
            time += difX;
        }
    }

    public static void changeDirection(int w, int h) {
        if (cx == w || cx == 0) {
            dx *= -1;
        }

        if (cy == h || cy == 0) {
            dy *= -1;
        }
    }
}
