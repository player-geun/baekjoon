package baekjoon.q1713;

import java.util.*;

public class Main {

    static int N; // 1 <= N <= 20
    static int numberOfStudent;  // <= 1000
    static int[] numbersOfRecommendation;
    static ArrayList<Candidate> candidates;
    static int[] elections = new int[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numberOfStudent = sc.nextInt();
        numbersOfRecommendation = new int[numberOfStudent];
        candidates = new ArrayList<>();

        for (int i = 0; i < numberOfStudent; i++) {
            numbersOfRecommendation[i] = sc.nextInt();
            elections[numbersOfRecommendation[i]]++;
        }

        electCandidate();

        int[] result = new int[candidates.size()];
        for (int i = 0; i < candidates.size(); i++) {
            result[i] = candidates.get(i).number;
        }

        Arrays.sort(result);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static void electCandidate() {
        // 투표를 모두 받는다.
        for (int i = 0; i < numberOfStudent; i++) {
            if (elections[numbersOfRecommendation[i]] > 0) {
                candidates.add(new Candidate(i, numbersOfRecommendation[i], elections[numbersOfRecommendation[i]]));
                elections[numbersOfRecommendation[i]] = 0;
            }
        }
        // 후보자를 정리한다.
        Collections.sort(candidates);

        while (candidates.size() > N) {
            candidates.remove(0);
        }
    }

    public static class Candidate implements Comparable<Candidate>{

        private int time;
        private int number;
        private int numberOfElection;

        public Candidate(int time, int number, int numberOfElection) {
            this.time = time;
            this.number = number;
            this.numberOfElection = numberOfElection;
        }

        @Override
        public int compareTo(Candidate o) {
            if (this.numberOfElection == o.numberOfElection) {
                return this.time - o.time;
            }

            return this.numberOfElection - o.numberOfElection;
        }
    }
}
