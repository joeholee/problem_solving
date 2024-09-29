import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] dp = new int[11];
	static int n;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			n = Integer.parseInt(br.readLine());
			dp = new int[n+1];
			solve();
		}
		System.out.println(sb);
	}
	
	static void solve() {
		dp[0]=0;
		dp[1]=1;
		if(n>=2) dp[2]=2;
		if(n>=3) dp[3]=4;
		if (n>=4)
			for(int i=4; i<=n; i++) dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
		sb.append(dp[n]).append("\n");
	}
}