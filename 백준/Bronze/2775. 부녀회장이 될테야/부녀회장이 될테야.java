import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T,k,n;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		dp = new int[15][15];
		for(int b=0; b<=14; b++) dp[0][b]=b;
		for(int a=1; a<=14; a++) {
			for(int b=1; b<=14; b++) dp[a][b]=dp[a][b-1]+dp[a-1][b];
		}
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			sb.append(dp[k][n]).append('\n');
		}
		System.out.println(sb);
	}
}