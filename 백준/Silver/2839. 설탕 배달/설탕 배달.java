import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dp;
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		if(N>=3) dp[3]=1;
		if(N>=5) dp[5]=1;
		for(int i=6; i<=N; i++) {
			if(i%5==0) dp[i]=dp[i-5]+1;
			else if(i%3==0) dp[i]=dp[i-3]+1;
			else {
				if(dp[i-5]!=0 && dp[i-3]!=0) dp[i] = Math.min(dp[i-5], dp[i-3])+1;
			}
		}
		System.out.println(dp[N]==0 ? -1 : dp[N]);
	}
}