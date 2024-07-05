import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> students = new LinkedHashSet<>();
        for (int i = 0; i < L; i++) {
            String student = br.readLine();
            if (students.contains(student)) {
                students.remove(student);
            }
            students.add(student);
        }

        int cnt = 0;
        for (String student : students) {
            bw.write(student);
            bw.newLine();
            cnt++;
            if (cnt == K) {
                break;
            }
        }
        bw.flush();
        bw.close();
    }

}