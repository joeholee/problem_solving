import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int T,n,ans;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			n = Integer.parseInt(br.readLine());
			dp = new int[n+1];
			if(n==1) ans=1;
			else if(n==2) ans=2;
			else if(n==3) ans=4;
			else ans=solve(n);
			System.out.println(ans);
		}
	}
	
	static int solve(int n) {
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		for(int i=4; i<=n; i++) dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
		return dp[n];
	}
}