import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int safe = Integer.MIN_VALUE;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] lab,copy;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lab = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) lab[r][c] = Integer.parseInt(st.nextToken());
		}
		dfs(0);
		System.out.println(safe);
	}
	
	static void dfs(int cnt) {
		if(cnt==3) {
			bfs();
			return;
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(lab[r][c]==0) {
					lab[r][c]=1;
					dfs(cnt+1);
					lab[r][c]=0;
				}
			}
		}
	}
	
	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(lab[r][c]==2) q.add(new int[] {r,c});
			}
		}
		copy = new int[N][M];
		for(int r=0; r<N; r++) copy[r] = lab[r].clone();
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int dir=0; dir<4; dir++) {
				int nr=cur[0]+dr[dir];
				int nc=cur[1]+dc[dir];
				if(nr<0||nr>=N||nc<0||nc>=M) continue;
				if(copy[nr][nc]==0) {
					copy[nr][nc]=2;
					q.add(new int[] {nr,nc});
				}
			}
		}
		int tmp=0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) if(copy[r][c]==0) tmp++;
		}
		safe = Math.max(safe, tmp);
	}
}