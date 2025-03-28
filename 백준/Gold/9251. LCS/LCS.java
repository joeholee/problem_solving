import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String s1,s2;
	static int N,M;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		s1 = br.readLine();
		s2 = br.readLine();
		N = s1.length();
		M = s2.length();
		dp = new int[N+1][M+1];
		solve();
		System.out.println(dp[N][M]);
	}
	
	static void solve() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=dp[i-1][j-1]+1;
				else dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
	}
}