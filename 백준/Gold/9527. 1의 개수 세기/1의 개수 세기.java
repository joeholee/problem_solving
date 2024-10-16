import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long A, B;
    static long[] dp = new long[55];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        calculateDP(); // DP 배열 초기화
        System.out.println(countOnesInRange(B) - countOnesInRange(A - 1));
    }

    static void calculateDP() {
        dp[0] = 1;
        for (int i = 1; i < 55; i++)
            dp[i] = (dp[i - 1] << 1) + (1L << i);
    }

    static long countOnesInRange(long n) {
        long count = n & 1; // n이 홀수인 경우 1 추가
        int size = (int) (Math.log(n) / Math.log(2)); // n의 이진수 자릿수 구하기
        for (int i = size; i > 0; i--) {
            if ((n & (1L << i)) != 0L) {
                count += dp[i - 1] + (n - (1L << i) + 1);
                n -= (1L << i); // n에서 현재 자릿수의 값을 빼줌
            }
        }
        return count;
    }
}
