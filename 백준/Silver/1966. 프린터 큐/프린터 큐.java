import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Document> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int priority = Integer.parseInt(st.nextToken());
                q.add(new Document(j, priority));
                pq.add(priority);
            }

            int cnt = 0;
            while (!q.isEmpty()) {
                Document document = q.poll();
                if (document.priority == pq.peek()) {
                    pq.poll();
                    cnt++;
                    if (document.index == M) {
                        bw.write(String.valueOf(cnt));
                        bw.newLine();
                        break;
                    }
                } else {
                    q.add(document);
                }
            }
        }

        bw.flush();
        bw.close();
    }

    static class Document {
        int index;
        int priority;

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

}
