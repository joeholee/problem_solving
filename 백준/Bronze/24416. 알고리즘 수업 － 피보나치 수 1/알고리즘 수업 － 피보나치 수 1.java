import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int nomarlCnt;
    static int dpCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        nomarlCnt = 1;
        dpCnt = 0;
        fibonacci(N);
        fibonacciDp(N);
        System.out.print(nomarlCnt + " " + dpCnt);

    }

    static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        nomarlCnt++;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int fibonacciDp(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dpCnt++;
        }
        return dp[n];
    }
}
