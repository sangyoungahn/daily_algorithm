package python_for_coding_test.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sorting_성적이낮은순서로학생출력하기 {

    static class Student implements Comparable<Student> {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        @Override
        public int compareTo(Student other) {
            if(this.score < other.score) {
                return -1;
            }
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Student> students = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String[] student = br.readLine().split(" ");
            String name = student[0];
            int score = Integer.parseInt(student[1]);
            students.add(new Student(name, score));
        }

        Collections.sort(students);

        for(int i=0; i<students.size(); i++) {
            System.out.print(students.get(i).getName() + " ");
        }
    }
}
