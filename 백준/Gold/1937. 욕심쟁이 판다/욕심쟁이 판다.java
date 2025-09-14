import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n,ans;
	static int[][] arr,dp;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int r=0; r<n; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<n; c++) arr[r][c] = Integer.parseInt(st.nextToken());
		}
		dp = new int[n][n];
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) ans = Math.max(ans, dfs(r,c));
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static int dfs(int r, int c) {
		if(dp[r][c]!=0) return dp[r][c];
		dp[r][c]=1;
		for(int dir=0; dir<4; dir++) {
			int nr = r+dr[dir];
			int nc = c+dc[dir];
			if(nr<0||nr>=n||nc<0||nc>=n) continue;
			if(arr[nr][nc]<=arr[r][c]) continue;
			dp[r][c] = Math.max(dp[r][c], dfs(nr,nc)+1);
		}
		return dp[r][c];
	}
}