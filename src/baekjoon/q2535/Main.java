package baekjoon.q2535;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, maxNationNumber;
    static int[] studentsOfNation;
    static Student[] students;

    public static void main(String[] args) {
        //입력
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        students = new Student[N];

        for (int i = 0; i < N; i++) {
            int nationNumber = sc.nextInt();
            students[i] = new Student(nationNumber, sc.nextInt(), sc.nextInt());
            maxNationNumber = Math.max(maxNationNumber, nationNumber);
        }

        studentsOfNation = new int[maxNationNumber + 1];

        // 정렬 하기
        Arrays.sort(students);

        //출력하기
        int index = 0;
        for (Student student : students) {
            if (index == 3) {
                break;
            }
            if (studentsOfNation[student.nationNumber] < 2) {
                System.out.println(student.nationNumber + " " + student.studentNumber);
                studentsOfNation[student.nationNumber]++;
                index++;
            } else {
                continue;
            }
        }
    }



    public static class Student implements Comparable<Student>{

        private int nationNumber;
        private int studentNumber;
        private int score;

        public Student(int nationNumber, int studentNumber, int score) {
            this.nationNumber = nationNumber;
            this.studentNumber = studentNumber;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return o.score - this.score;
        }
    }
}
