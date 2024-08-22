import java.io.*;
import java.util.*;

public class Main {

    static class BoardInfo {
        int[][] board;
        int cnt;

        public BoardInfo(int[][] board, int cnt) {
            this.board = board;
            this.cnt = cnt;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<BoardInfo> boards = new LinkedList<>();
        boards.add(new BoardInfo(board, 0));

        int maxValue = 0;
        while (!boards.isEmpty()) {
            BoardInfo cur = boards.poll();
            if (cur.cnt == 5) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        maxValue = Math.max(maxValue, cur.board[i][j]);
                    }
                }
                continue;
            }

            boards.add(new BoardInfo(moveUp(N, cur.board), cur.cnt + 1));
            boards.add(new BoardInfo(moveDown(N, cur.board), cur.cnt + 1));
            boards.add(new BoardInfo(moveLeft(N, cur.board), cur.cnt + 1));
            boards.add(new BoardInfo(moveRight(N, cur.board), cur.cnt + 1));
        }

        bw.write(String.valueOf(maxValue));
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static int[][] moveUp(int N, int[][] board) {
        int[][] newBoard = new int[N][N];
        List<Queue<Integer>> queueList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                if (board[j][i] == 0) {
                    continue;
                }
                queue.add(board[j][i]);
            }
            queueList.add(queue);
        }

        for (int i = 0; i < N; i++) {
            int j = 0;
            Queue<Integer> queue = queueList.get(i);
            while (!queue.isEmpty()) {
                int ele = queue.poll();
                if (!queue.isEmpty()) {
                    if (ele == queue.peek()) {
                        int nextEle = queue.poll();
                        newBoard[j++][i] = ele + nextEle;
                    } else {
                        newBoard[j++][i] = ele;
                    }
                } else {
                    newBoard[j][i] = ele;
                }
            }
        }
        return newBoard;
    }

    public static int[][] moveDown(int N, int[][] board) {
        int[][] newBoard = new int[N][N];
        List<Queue<Integer>> queueList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int j = N - 1; j >= 0; j--) {
                if (board[j][i] == 0) {
                    continue;
                }
                queue.add(board[j][i]);
            }
            queueList.add(queue);
        }

        for (int i = 0; i < N; i++) {
            int j = N - 1;
            Queue<Integer> queue = queueList.get(i);
            while (!queue.isEmpty()) {
                int ele = queue.poll();
                if (!queue.isEmpty()) {
                    if (ele == queue.peek()) {
                        int nextEle = queue.poll();
                        newBoard[j--][i] = ele + nextEle;
                    } else {
                        newBoard[j--][i] = ele;
                    }
                } else {
                    newBoard[j][i] = ele;
                }
            }
        }
        return newBoard;
    }

    public static int[][] moveLeft(int N, int[][] board) {
        int[][] newBoard = new int[N][N];
        List<Queue<Integer>> queueList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                queue.add(board[i][j]);
            }
            queueList.add(queue);
        }

        for (int i = 0; i < N; i++) {
            int j = 0;
            Queue<Integer> queue = queueList.get(i);
            while (!queue.isEmpty()) {
                int ele = queue.poll();
                if (!queue.isEmpty()) {
                    if (ele == queue.peek()) {
                        int nextEle = queue.poll();
                        newBoard[i][j++] = ele + nextEle;
                    } else {
                        newBoard[i][j++] = ele;
                    }
                } else {
                    newBoard[i][j] = ele;
                }
            }
        }
        return newBoard;
    }

    public static int[][] moveRight(int N, int[][] board) {
        int[][] newBoard = new int[N][N];
        List<Queue<Integer>> queueList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int j = N - 1; j >= 0; j--) {
                if (board[i][j] == 0) {
                    continue;
                }
                queue.add(board[i][j]);
            }
            queueList.add(queue);
        }

        for (int i = 0; i < N; i++) {
            int j = N - 1;
            Queue<Integer> queue = queueList.get(i);
            while (!queue.isEmpty()) {
                int ele = queue.poll();
                if (!queue.isEmpty()) {
                    if (ele == queue.peek()) {
                        int nextEle = queue.poll();
                        newBoard[i][j--] = ele + nextEle;
                    } else {
                        newBoard[i][j--] = ele;
                    }
                } else {
                    newBoard[i][j] = ele;
                }
            }
        }
        return newBoard;
    }

}