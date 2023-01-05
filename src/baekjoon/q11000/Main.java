package baekjoon.q11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int lectureNum;
    static Lecture[] timeTable;

    public static void main(String[] args) throws IOException {
        input();
        greedy();
        output();

    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        timeTable = new Lecture[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            Lecture lecture = new Lecture(startTime, endTime);
            timeTable[i] = lecture;
        }
    }

    static void greedy() {
        Arrays.sort(timeTable);

        Lecture currentLecture = timeTable[0];
        lectureNum = 1;

        for (int i = 1; i < N; i++) {

            if(currentLecture.startTime == timeTable[i].startTime) continue;

            if (currentLecture.endTime <= timeTable[i].startTime) {
                currentLecture = timeTable[i];
                lectureNum++;
            }
        }
    }

    static void output() {
        System.out.println(lectureNum);
    }

    static class Lecture implements Comparable<Lecture>{
        private int startTime;
        private int endTime;

        public Lecture(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.startTime == o.startTime) {
                return this.endTime - o.endTime;
            } else {
                return this.startTime - o.startTime;
            }
        }
    }
}
