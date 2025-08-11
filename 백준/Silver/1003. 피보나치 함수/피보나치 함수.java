import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T,N;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			dp = new int[N+1][2];
			dp[0][0] = 1;
			dp[0][1] = 0;
			if(N>=1) {
				dp[1][0] = 0;
				dp[1][1] = 1;
			}
			if(N>=2) {
				for(int i=2; i<=N; i++) {
					dp[i][0] = dp[i-2][0] + dp[i-1][0];
					dp[i][1] = dp[i-2][1] + dp[i-1][1];
				}
			}
			sb.append(dp[N][0]).append(' ').append(dp[N][1]).append('\n');
		}
		System.out.println(sb);
	}
}