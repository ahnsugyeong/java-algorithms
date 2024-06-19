import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int N = Integer.parseInt(br.readLine());
        List<Person> people = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            people.add(new Person(weight, height));
        }
        
        for(int i = 0; i < people.size(); i++) {
            Person curPerson = people.get(i);
            for(int j = 0; j < people.size(); j++) {
                if (i == j) {
                    continue;
                }
                Person comparePerson = people.get(j);
                if (comparePeople(curPerson, comparePerson)) {
                    curPerson.rank++;
                }
            }
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < people.size(); i++) {
            bw.write(String.valueOf(people.get(i).rank) + " ");
        }
        bw.flush();
        bw.close();
    }
    
    static boolean comparePeople(Person curPerson, Person comparePerson) {
        if (curPerson.weight < comparePerson.weight && curPerson.height < comparePerson.height) {
            return true;
        }
        return false;
    }
    
    static class Person {
        public int weight;
        public int height;
        public int rank;
        
        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
            this.rank = 1;
        }
    }
    
}