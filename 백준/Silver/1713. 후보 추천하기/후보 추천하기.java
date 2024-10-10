import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Student> students = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int studentNumber = Integer.parseInt(st.nextToken());
            int studentIdx = findByNumber(students, studentNumber);

            if (studentIdx == -1) {
                if (students.size() >= N) {
                    Collections.sort(students);
                    students.remove(0);
                }
                students.add(new Student(studentNumber, 1, i));
            } else {
                students.get(studentIdx).recommendCnt++;
            }
        }

        int[] ans = new int[students.size()];
        for (int i = 0; i < students.size(); i++) {
            ans[i] = students.get(i).number;
        }
        Arrays.sort(ans);

        for (int i = 0; i < students.size(); i++) {
            System.out.print(ans[i] + " ");
        }
    }

    static class Student implements Comparable<Student> {
        int number;
        int recommendCnt;
        int lastRecommendedDate;

        public Student(int number, int recommendCnt, int lastRecommendedDate) {
            this.number = number;
            this.recommendCnt = recommendCnt;
            this.lastRecommendedDate = lastRecommendedDate;
        }

        @Override
        public int compareTo(Student other) {
            if (this.recommendCnt == other.recommendCnt) {
                return Integer.compare(this.lastRecommendedDate, other.lastRecommendedDate);
            }
            return Integer.compare(this.recommendCnt, other.recommendCnt);
        }
    }

    static int findByNumber(List<Student> students, int studentNumber) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).number == studentNumber) {
                return i;
            }
        }
        return -1;
    }

}