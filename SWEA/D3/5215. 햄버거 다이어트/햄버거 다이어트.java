import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,L;
	static int[] T,K;
	static int[][] dp;
	
	public static void main(String args[]) throws Exception
	{
		int tc = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= tc; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			dp = new int[N+1][L+1];
			T = new int[N+1];
			K = new int[N+1];
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				T[i]=Integer.parseInt(st.nextToken());
				K[i]=Integer.parseInt(st.nextToken());
			}
			solve();
			sb.append("#").append(test_case).append(" ").append(dp[N][L]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void solve() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=L; j++) {
				if(K[i]>j) dp[i][j]=dp[i-1][j];
				else dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-K[i]]+T[i]);
			}
		}
	}
}