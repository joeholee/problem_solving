import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] board;
	static boolean[] vis;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		vis = new boolean[N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) board[r][c] = Integer.parseInt(st.nextToken());
		}
		comb(0,0);
		System.out.println(ans);
	}
	
	static void comb(int cnt, int idx) {
		if(cnt==N/2) {
			calc();
			return;
		}
		for(int i=idx; i<N; i++) {
			if(!vis[i]) {
				vis[i] = true;
				comb(cnt+1, i+1);
				vis[i] = false;
			}
		}
	}
	
	static void calc() {
		int start=0, link = 0;
		for(int r=0; r<N-1; r++) {
			for(int c=r+1; c<N; c++) {
				if(vis[r] && vis[c]) start+=board[r][c]+board[c][r];
				if(!vis[r] && !vis[c]) link+=board[r][c]+board[c][r];
			}
		}
		int tmp = Math.abs(start-link);
		if(tmp==0) {
			System.out.println(tmp);
			System.exit(0);
		}
		ans = Math.min(ans, tmp);
	}
}