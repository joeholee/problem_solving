import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int[] memo;  // 메모이제이션 배열 추가
    static int nomarlCnt;
    static int dpCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        memo = new int[N + 1];  // 메모이제이션 배열 초기화
        nomarlCnt = 1;
        dpCnt = 0;
        System.out.print(fibonacciDp(N) + " " + dpCnt);
    }



    // DP를 활용한 피보나치 계산
    static int fibonacciDp(int n) {
        dp[1] = dp[2] = 1;  // 초기 값 설정

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dpCnt++;
        }
        return dp[n];
    }
}