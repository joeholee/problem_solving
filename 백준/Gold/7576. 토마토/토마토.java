import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int M,N,ans;
	static int[][] tomato;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<int[]> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				tomato[r][c] = Integer.parseInt(st.nextToken());
				if(tomato[r][c]==1) q.add(new int[] {r,c});
			}
		}
		solve();
		System.out.println(ans);
	}
	
	static void solve() {
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int dir=0; dir<4; dir++) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=N||nc<0||nc>=M) continue;
				if(tomato[nr][nc]==0) {
					tomato[nr][nc]=tomato[cur[0]][cur[1]]+1;
					q.add(new int[] {nr,nc});
				}
			}
		}
		ans = Integer.MIN_VALUE;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(tomato[r][c]==0) {
					ans = -1;
					return;
				}
				ans = Math.max(ans, tomato[r][c]);
			}
		}
		ans-=1;
	}
}