import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] price = new int[4]; // 1일 1달 3달 1
	static int[] plan = new int[12];
	static int[] dp;
	
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) price[i]=Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<12; i++) plan[i]=Integer.parseInt(st.nextToken());
			solve();
			sb.append("#").append(test_case).append(" ").append(dp[11]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void solve() {
		dp = new int[12];
		dp[0]=Math.min(price[0]*plan[0], price[1]);
		for(int i=1; i<12; i++) {
			dp[i]=dp[i-1]+Math.min(price[0]*plan[i], price[1]);
			if(i>=2) dp[i]=Math.min(dp[i], (i>=3 ? dp[i-3] : 0)+price[2]);
		}
		dp[11]=Math.min(dp[11], price[3]);
	}
}