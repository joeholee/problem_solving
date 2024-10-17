import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int[] dp = new int[N]; // dp[i]는 i번째까지의 최대 연속합

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 초기값 설정
        dp[0] = numbers[0];
        int maxValue = dp[0];

        // 동적 프로그래밍을 이용하여 최대 연속합 계산
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + numbers[i], numbers[i]);
            maxValue = Math.max(maxValue, dp[i]);
        }

        // 결과 출력
        System.out.print(maxValue);
    }
}