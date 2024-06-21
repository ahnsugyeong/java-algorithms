import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        List<Network> networks = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int firstComputer = Integer.parseInt(st.nextToken());
            int secondComputer = Integer.parseInt(st.nextToken());
            networks.add(new Network(firstComputer, secondComputer));
        }
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(1);
        visited.add(1);
        int cnt = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            Iterator<Network> iterator = networks.iterator();
            while (iterator.hasNext()) {
                Network network = iterator.next();
                if (network.firstComputer == cur && !visited.contains(network.secondComputer)) {
                    q.add(network.secondComputer);
                    visited.add(network.secondComputer);
                    iterator.remove();
                } else if (network.secondComputer == cur && !visited.contains(network.firstComputer)) {
                    q.add(network.firstComputer);
                    visited.add(network.firstComputer);
                    iterator.remove();
                }
            }
        }
        
        bw.write(String.valueOf(cnt - 1));
        bw.flush();
        bw.close();
    }
    
    private static class Network {
        int firstComputer;
        int secondComputer;
        
        private Network(int firstComputer, int secondComputer) {
            this.firstComputer = firstComputer;
            this.secondComputer = secondComputer;
        }
    }
    
}
