package baekjoon.q2980;

import java.util.Scanner;

public class Main {

    static int N, L, time, currentPosition;
    static int[] road;
    static TrafficLight[] trafficLights;

    static final int GREEN = 1;
    static final int RED = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        road = new int[L];
        trafficLights = new TrafficLight[N];

        for (int i = 0; i < N; i++) {
            trafficLights[i] = new TrafficLight(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        initRoad();
        calculateMovingTime();

        if (N == 1 && L == 1) {
            System.out.println(trafficLights[0].redTime);
            return;
        }
        System.out.println(time);
    }

    public static void calculateMovingTime() {
        while (currentPosition != L - 1) {
            if (canMove()) {
                currentPosition++;
                time++;
            } else {
                time++;
            }

            updateTrafficLights();
        }
    }

    public static boolean canMove() {
        if (road[currentPosition] == GREEN || road[currentPosition] == 0) {
            return true;
        }

        return false;
    }

    public static void initRoad() {
        for (TrafficLight trafficLight : trafficLights) {
            road[trafficLight.position - 1] = RED;
        }
    }

    public static void updateTrafficLights() {
        for (TrafficLight trafficLight : trafficLights) {
            int currentLight = road[trafficLight.position - 1];
            road[trafficLight.position - 1] = trafficLight.execute(currentLight);
        }
    }

    public static class TrafficLight{

        private int position;
        private int redTime;
        private int greenTime;

        private int remainedGreenTime;
        private int remainedRedTime;

        public TrafficLight(int position, int redTime, int greenTime) {
            this.position = position;
            this.redTime = redTime;
            this.greenTime = greenTime;
            this.remainedRedTime = redTime;
            this.remainedGreenTime = greenTime;
        }

        public int execute(int light) {
            if (light == RED) {
                remainedRedTime--;
                if (isChangeLight(RED)) {
                    remainedRedTime = redTime;
                    return GREEN;
                }

                return RED;
            } else {
                remainedRedTime--;
                if (isChangeLight(GREEN)) {
                    remainedGreenTime = greenTime;
                    return RED;
                }

                return GREEN;
            }
        }

        public boolean isChangeLight(int light) {
            if (light == RED) {
                if (remainedRedTime == 0) {
                    return true;
                }

                return false;
            } else {
                if (remainedGreenTime == 0) {
                    return true;
                }

                return false;
            }
        }
    }
}
