import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static final int INF = 1_000_000;
	static int N,ans=INF;
	static int[][] cost,dp;
 	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N][3];
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(i==j) dp[0][j] = cost[0][j];
				else dp[0][j] = INF;
			}
			for(int j=1; j<N; j++) {
				dp[j][0] = cost[j][0]+Math.min(dp[j-1][1], dp[j-1][2]);
				dp[j][1] = cost[j][1]+Math.min(dp[j-1][0], dp[j-1][2]);
				dp[j][2] = cost[j][2]+Math.min(dp[j-1][0], dp[j-1][1]);
			}
			for(int j=0; j<3; j++) {
				if(i!=j) ans = Math.min(ans, dp[N-1][j]);
			}
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}