import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,ans=987654321;
	static int[][] G;
	static boolean[][] vis;
	static final int[] dr = {-1,0,1,0};
	static final int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		G = new int[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) G[r][c] = Integer.parseInt(st.nextToken());
		}
		vis = new boolean[N][N];
		comb(0,0,0);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void comb(int cnt, int idx, int sum) {
		if(sum>=ans) return;
		if(cnt==3) {
			ans = Math.min(ans, sum);
			return;
		}
		for(int i=idx; i<N*N; i++) {
			int r = i/N, c = i%N;
			if(r==0||r==N-1||c==0||c==N-1) continue;
			if(!canVisit(r,c)) continue;
			int tmp = calcSum(r,c);
			check(r,c,true);
			comb(cnt+1,i+1,sum+tmp);
			check(r,c,false);
		}
	}
	
	static boolean canVisit(int r, int c) {
		if(vis[r][c]) return false;
		for(int dir=0; dir<4; dir++) {
			int nr = r+dr[dir];
			int nc = c+dc[dir];
			if(vis[nr][nc]) return false;
		}
		return true;
	}
	
	static int calcSum(int r, int c) {
		int sum = 0;
		sum+=G[r][c];
		for(int dir=0; dir<4; dir++) {
			int nr = r+dr[dir];
			int nc = c+dc[dir];
			sum+=G[nr][nc];
		}
		return sum;
	}
	
	static void check(int r, int c, boolean flag) {
		vis[r][c] = flag;
		for(int dir=0; dir<4; dir++) {
			int nr = r+dr[dir];
			int nc = c+dc[dir];
			vis[nr][nc] = flag;
		}
	}
}