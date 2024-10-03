import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[] dp,wine;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		wine = new int[n+1];
		for(int i=1; i<=n; i++) wine[i]=Integer.parseInt(br.readLine());
		dp[1]=wine[1];
		if(n>=2) dp[2]=dp[1]+wine[2];
		if(n>=3) {
			for(int i=3; i<=n; i++) {
				dp[i]=Math.max(dp[i-1], wine[i]+Math.max(dp[i-3]+wine[i-1],dp[i-2]));
			}
		}
		System.out.println(dp[n]);
	}
}