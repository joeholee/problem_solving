import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] dp = new int[1001];
    
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=1;
        for(int i=4; i<=N; i++) dp[i]=Math.min(dp[i-1],dp[i-3])+1;
        System.out.println(dp[N]%2==0 ? "SK" : "CY");
    }
} 