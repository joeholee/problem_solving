import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 비트마스크를 활용해 조합을 생성하고 팀 구성을 나눔
        int totalStates = (1 << N);  // 2^N 상태 수
        for (int i = 1; i < totalStates; i++) {
            // 팀 구성원의 수가 N/2가 아닌 경우는 패스
            if (Integer.bitCount(i) != N / 2) continue;

            calculateDifference(i);
        }

        System.out.println(minDifference);
    }

    // 비트마스크로 선택된 조합에 대해 차이를 계산
    public static void calculateDifference(int teamStartMask) {
        int teamStart = 0, teamLink = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if ((teamStartMask & (1 << i)) != 0 && (teamStartMask & (1 << j)) != 0) {
                    // i와 j가 모두 teamStart에 속하는 경우
                    teamStart += arr[i][j] + arr[j][i];
                } else if ((teamStartMask & (1 << i)) == 0 && (teamStartMask & (1 << j)) == 0) {
                    // i와 j가 모두 teamLink에 속하는 경우
                    teamLink += arr[i][j] + arr[j][i];
                }
            }
        }

        int difference = Math.abs(teamStart - teamLink);
        minDifference = Math.min(minDifference, difference);
    }
}
