package baekjoon.q10825;

import java.util.*;

public class Main {

    static int N;
    static Student[] students;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        students = new Student[N];

        for (int i = 0; i < N; i++) {
            students[i] = new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(students);

        for (Student student : students) {
            System.out.println(student.name);
        }
    }

    public static class Student implements Comparable<Student> {

        private String name;
        private int korean;
        private int english;
        private int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if(korean != o.korean) {
                return o.korean - korean;
            }
            if (english != o.english) {
                return english - o.english;
            }
            if (math != o.math) {
                return o.math - math;
            }

            return name.compareTo(o.name);
        }
    }
}
