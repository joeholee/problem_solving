import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,ans=987654321;
	static int[][] G;
	static int[] pick = new int[3];
	static final int[] dr = {-1,0,1,0};
	static final int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		G = new int[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) G[r][c] = Integer.parseInt(st.nextToken());
		}
		comb(0,0);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void comb(int cnt, int idx) {
		if(cnt==3) {
			boolean[][] vis = new boolean[N][N];
			for(int i : pick) {
				int curR = i/N, curC = i%N;
				if(vis[curR][curC]) return;
				vis[curR][curC]=true;
				for(int dir=0; dir<4; dir++) {
					int nr = curR+dr[dir];
					int nc = curC+dc[dir];
					if(vis[nr][nc]) return;
					vis[nr][nc]=true;
				}
			}
			int tmp = 0;
			for(int i : pick) {
				int curR = i/N, curC = i%N;
				tmp+=G[i/N][i%N];
				for(int dir=0; dir<4; dir++) {
					int nr = curR+dr[dir];
					int nc = curC+dc[dir];
					tmp+=G[nr][nc];
				}
			}
			ans = Math.min(ans, tmp);
			return;
		}
		for(int i=idx; i<N*N; i++) {
			int r = i/N, c = i%N;
			if(r>0&&r<N-1&&c>0&&c<N-1) {
				pick[cnt]=i;
				comb(cnt+1,i+1);
			}
		}
	}
}