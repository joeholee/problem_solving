import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int N;
    static int minSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];
        minSum = Integer.MAX_VALUE;

        // 팀을 N/2명씩 나누는 조합을 구함
        combination(0, 0);

        System.out.println(minSum);
    }

    public static void combination(int idx, int count) {
        // 팀을 N/2명으로 나누었을 때
        if (count == N / 2) {
            calculateDifference();
            return;
        }

        // 조합 구하기
        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    public static void calculateDifference() {
        int teamStart = 0, teamLink = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    teamStart += arr[i][j] + arr[j][i];
                } else if (!visited[i] && !visited[j]) {
                    teamLink += arr[i][j] + arr[j][i];
                }
            }
        }

        int difference = Math.abs(teamStart - teamLink);
        minSum = Math.min(minSum, difference);
    }
}
