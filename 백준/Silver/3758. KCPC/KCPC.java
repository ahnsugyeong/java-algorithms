import java.util.*;
import java.io.*;

public class Main {

    static class TeamScore {
        int teamId;
        int[] score;
        int submitIndex;
        int submitCnt;

        public TeamScore(int teamId, int k, int submitIndex) {
            this.teamId = teamId;
            this.score = new int[k];
            this.submitIndex = submitIndex;
            this.submitCnt = 0;
        }

        public int getScore() {
            int sum = 0;
            for (int i = 0; i < score.length; i++) {
                sum += this.score[i];
            }
            return sum;
        }

        public String toString() {
            return "teamId = " + teamId + ", score = " + getScore() + ", submitIndex = " + submitIndex + ", submitCnt = " + submitCnt + "\n";
        }
    }

    static class TeamScoreComparator implements Comparator<TeamScore> {
        public int compare(TeamScore l1, TeamScore l2) {
            if (l1.getScore() == l2.getScore()) {
                if (l1.submitCnt == l2.submitCnt) {
                    return Integer.compare(l1.submitIndex, l2.submitIndex);
                }
                return Integer.compare(l1.submitCnt, l2.submitCnt);
            }
            return Integer.compare(l2.getScore(), l1.getScore());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());   // 팀의 개수
            int k = Integer.parseInt(st.nextToken());   // 문제의 개수
            int t = Integer.parseInt(st.nextToken());   // 팀 ID
            int m = Integer.parseInt(st.nextToken());   // 로그 엔트리 개수

            List<TeamScore> teamScoreBoard = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken());
                int problemId = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
                TeamScore teamScore = findByTeamId(teamScoreBoard, teamId);
                if (teamScore == null) {
                    teamScore = new TeamScore(teamId, k, j);
                    teamScoreBoard.add(teamScore);
                }
                teamScore.score[problemId - 1] = Math.max(teamScore.score[problemId - 1], score);
                teamScore.submitIndex = j;
                teamScore.submitCnt++;

            }

            // 정렬 기준 -> score ↑, submitIndex ↓, submitCnt ↓
            teamScoreBoard.sort(new TeamScoreComparator());

            int rank = 0;
            for (int j = 0; j < teamScoreBoard.size(); j++) {
                if (teamScoreBoard.get(j).teamId == t) {
                    rank = j + 1;
                    break;
                }
            }

            bw.write(String.valueOf(rank));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static TeamScore findByTeamId(List<TeamScore> teamScoreBoard, int teamId) {
        for (TeamScore teamScore : teamScoreBoard) {
            if (teamScore.teamId == teamId) {
                return teamScore;
            }
        }
        return null;
    }

}