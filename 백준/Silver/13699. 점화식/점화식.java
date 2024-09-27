import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static long[] dp = new long[36];
    
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        dp[0]=1;
        for(int i=1; i<=n; i++) {
            for(int j=0; j<i; j++) {
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        System.out.println(dp[n]);
    }
}