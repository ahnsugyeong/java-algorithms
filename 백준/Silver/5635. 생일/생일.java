import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            students.add(new Student(name, year, month, day));
        }

        Collections.sort(students);

        System.out.println(students.get(N - 1).name);
        System.out.println(students.get(0).name);

    }

    static class Student implements Comparable<Student> {
        String name;
        int year;
        int month;
        int day;

        public Student(String name, int year, int month, int day) {
            this.name = name;
            this.year = year;
            this.month = month;
            this.day = day;
        }

        @Override
        public int compareTo(Student o) {
            if (this.year == o.year) {
                if (this.month == o.month) {
                    return Integer.compare(this.day, o.day);
                }
                return Integer.compare(this.month, o.month);
            }
            return Integer.compare(this.year, o.year);
        }
    }
}
