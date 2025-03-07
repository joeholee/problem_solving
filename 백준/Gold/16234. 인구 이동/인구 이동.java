import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {
    static int N, L, R, ans;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] board;
    static boolean[][] vis;
    static boolean canMove;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        solve();
        System.out.println(ans);
    }

    static void solve() {
        while (true) {
            canMove = false;
            vis = new boolean[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (!vis[r][c]) {
                        bfs(r, c);
                    }
                }
            }
            if (!canMove) break;
            ans++;
        }
    }

    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        ArrayList<int[]> union = new ArrayList<>();
        q.add(new int[] {r, c});
        vis[r][c] = true;
        union.add(new int[] {r, c});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nr = cur[0] + dr[dir];
                int nc = cur[1] + dc[dir];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || vis[nr][nc]) continue;
                int diff = Math.abs(board[cur[0]][cur[1]] - board[nr][nc]);
                if (L <= diff && diff <= R) {
                    q.add(new int[] {nr, nc});
                    union.add(new int[] {nr, nc});
                    vis[nr][nc] = true;
                    canMove = true;
                }
            }
        }

        if (canMove) {
            int sum = 0;
            for (int i = 0; i < union.size(); i++) {
                sum += board[union.get(i)[0]][union.get(i)[1]];
            }
            int avg = sum / union.size();
            for (int i = 0; i < union.size(); i++) {
                board[union.get(i)[0]][union.get(i)[1]] = avg;
            }
        }
    }
}
