import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int M,N;
	static int[][] arr;
	static int[][] dp;
	static final int[] dr = {-1,0,1,0};
	static final int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		for(int r=0; r<M; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) arr[r][c] = Integer.parseInt(st.nextToken());
		}
		dp = new int[M][N];
		for(int r=0; r<M; r++) Arrays.fill(dp[r], -1);
		dfs(0,0);
		bw.write(dp[0][0]+"");
		bw.close();
		br.close();
	}
	
	static void dfs(int r, int c) {
		if(r==M-1 && c==N-1) {
			dp[r][c]=1;
			return;
		}
		if(dp[r][c]!=-1) return;
		dp[r][c]=0;
		for(int dir=0; dir<4; dir++) {
			int nr = r+dr[dir];
			int nc = c+dc[dir];
			if(nr<0||nr>=M||nc<0||nc>=N) continue;
			if(arr[nr][nc]<arr[r][c]) {
				if(dp[nr][nc]==-1) dfs(nr,nc);
				dp[r][c]+=dp[nr][nc];
			}
		}
	}
}