import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n,ans;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		dp[1]=1;
		if(n>1) dp[2]=2;
		solve();
		System.out.println(dp[n]);
	}
	
	static void solve() {
		for(int i=3; i<=n; i++) dp[i]=(dp[i-1]+dp[i-2])%10007;
	}
}