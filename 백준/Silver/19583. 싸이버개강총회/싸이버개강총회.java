import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] times = br.readLine().split(" ");
        int S = convertStringToInt(times[0]);
        int E = convertStringToInt(times[1]);
        int Q = convertStringToInt(times[2]);

        Set<String> attendees = new HashSet<>();

        int cnt = 0;
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] input = line.split(" ");
            int time = convertStringToInt(input[0]);
            String name = input[1];
            if (!attendees.contains(name)) {
                if (S >= time) {
                    attendees.add(name);
                }
            } else {
                if (E <= time && Q >= time) {
                    attendees.remove(name);
                    cnt++;
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    public static int convertStringToInt(String str) {
        String[] times = str.split(":");
        int hour = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);
        return hour * 60 + minute;
    }

}