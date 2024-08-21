import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static int N,M,w,b;
	static int[] cur;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static char[][] war;
	static boolean[][] vis;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		String[] sz = br.readLine().split(" ");
		N = Integer.parseInt(sz[0]);
		M = Integer.parseInt(sz[1]);
		war = new char[M][N];
		vis = new boolean[M][N];
		for(int r=0; r<M; r++) {
			char[] row = br.readLine().toCharArray();
			for(int c=0; c<N; c++) war[r][c]=row[c];
		}
		for(int r=0; r<M; r++) {
			for(int c=0; c<N; c++) bfs(r,c);
		}
		System.out.print(w+" "+b);
	}
	
	static void bfs(int r, int c) {
		int tmp=0;
		char col=war[r][c];
		if(vis[r][c]) return;
		q.add(new int[] {r,c});
		vis[r][c]=true;
		while(!q.isEmpty()) {
			cur = q.poll();
			tmp++;
			for(int dir=0; dir<4; dir++) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=M||nc<0||nc>=N) continue;
				if(vis[nr][nc]||war[nr][nc]!=war[cur[0]][cur[1]]) continue;
				q.add(new int[] {nr,nc});
				vis[nr][nc]=true;
			}
		}
		if(col=='W') w+=tmp*tmp;
		else b+=tmp*tmp;
	}
}