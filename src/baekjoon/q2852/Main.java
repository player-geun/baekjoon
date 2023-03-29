package baekjoon.q2852;

import java.util.*;
import java.io.*;

public class Main {

    static final int END_TIME = 48 * 60;
    static Queue<Integer> goalTimes;
    static int N, firstScore, secondScore, firstTime, secondTime, startWinTime, winner;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        goalTimes = new LinkedList<>();
        startWinTime = -1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            int time = convertStringToInt(str);

            calculateWinTime(team, time);
        }

        if (winner == 1) {
            firstTime += END_TIME - startWinTime;
        } else if(winner == 2) {
            secondTime += END_TIME - startWinTime;
        }

        System.out.println(convertIntToString(firstTime));
        System.out.println(convertIntToString(secondTime));
    }

    public static String convertIntToString(int time) {
        String minute = String.valueOf(time / 60);

        if (minute.length() == 1) {
            minute = "0" + minute;
        }

        String second = String.valueOf(time % 60);

        if (second.length() == 1) {
            second = "0" + second;
        }

        return minute + ":" + second;
    }

    public static void calculateWinTime(int team, int time) {
        if (team == 1) {
            firstScore++;
        } else {
            secondScore++;
        }

        if (startWinTime == -1) {
            startWinTime = time;
            if (firstScore < secondScore) {
                winner = 2;
            } else {
                winner = 1;
            }
            return;
        }

        if (firstScore < secondScore) {
            secondTime += time - startWinTime;
            startWinTime = time;
            winner = 2;
        } else if (firstScore > secondScore) {
            firstTime += time - startWinTime;
            startWinTime = time;
            winner = 1;
        } else {
            if(winner == 1) {
                firstTime += time - startWinTime;
            } else {
                secondTime += time - startWinTime;
            }
            startWinTime = -1;
            winner = 0;
        }
    }

    public static int convertStringToInt(String str) {
        int minute = Integer.parseInt(str.substring(0, 2));
        int second = Integer.parseInt(str.substring(3, 5));

        return minute * 60 + second;
    }
}
