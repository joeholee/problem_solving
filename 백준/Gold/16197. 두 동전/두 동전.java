import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, minCnt;
    static int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌 이동
    static int[] dy = {0, 1, 0, -1};
    static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] maps = new char[N][M];
        int firstX = -1, firstY = -1, secondX = -1, secondY = -1;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                maps[i][j] = str.charAt(j);
                if (maps[i][j] == 'o') {
                    if (firstX == -1) {
                        firstX = i;
                        firstY = j;
                    } else {
                        secondX = i;
                        secondY = j;
                    }
                }
            }
        }

        minCnt = 11; // 최대 10번까지만 움직임 허용
        visited = new boolean[N][M][N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{firstX, firstY, secondX, secondY, 0});
        visited[firstX][firstY][secondX][secondY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x1 = cur[0], y1 = cur[1], x2 = cur[2], y2 = cur[3], cnt = cur[4];

            if (cnt >= 10) { // 10번 초과하면 -1 출력
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx1 = x1 + dx[i], ny1 = y1 + dy[i];
                int nx2 = x2 + dx[i], ny2 = y2 + dy[i];

                // 두 동전 중 하나가 떨어졌을 경우
                boolean firstOut = !isValid(nx1, ny1);
                boolean secondOut = !isValid(nx2, ny2);

                if (firstOut && secondOut) {
                    continue; // 둘 다 떨어지면 무시
                }

                if (firstOut || secondOut) {
                    minCnt = cnt + 1; // 하나만 떨어지면 성공
                    System.out.print(minCnt);
                    return;
                }

                // 벽에 부딪히면 원래 자리에 남음
                if (maps[nx1][ny1] == '#') {
                    nx1 = x1;
                    ny1 = y1;
                }
                if (maps[nx2][ny2] == '#') {
                    nx2 = x2;
                    ny2 = y2;
                }

                // 방문하지 않은 위치일 때만 큐에 추가
                if (!visited[nx1][ny1][nx2][ny2]) {
                    visited[nx1][ny1][nx2][ny2] = true;
                    queue.offer(new int[]{nx1, ny1, nx2, ny2, cnt + 1});
                }
            }
        }

        // 10번 이내로 두 동전 중 하나만 떨어지지 않으면 -1
        System.out.print(-1);
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}