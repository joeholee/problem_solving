import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int ans = Integer.MIN_VALUE;
	static int[][] arr,dp;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new int[n][n];
		for(int r=0; r<n; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<=r; c++) arr[r][c] = Integer.parseInt(st.nextToken());
		}
		dp[0][0] = arr[0][0];
		for(int r=1; r<n; r++) {
			dp[r][0] = dp[r-1][0]+arr[r][0];
			for(int c=1; c<r; c++) {
				dp[r][c] = Math.max(dp[r-1][c-1], dp[r-1][c]) + arr[r][c];
			}
			dp[r][r] = dp[r-1][r-1] + arr[r][r];
		}
		for(int i : dp[n-1]) ans = Math.max(ans, i);
		System.out.println(ans);
	}
}