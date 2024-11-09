import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,r1,c1,r2,c2;
	static int[][] board,dist;
	static int[] cur;
	static int[] dr = {-2,-2,0,0,2,2};
	static int[] dc = {-1,1,-2,2,-1,1};
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		dist = new int[N][N];
		st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		for(int r=0; r<N; r++) Arrays.fill(dist[r], -1);
		solve();
		System.out.println(dist[r2][c2]);
	}
	
	static void solve() {
		dist[r1][c1]=0;
		q.add(new int[] {r1,c1});
		while(!q.isEmpty()) {
			cur = q.poll();
			for(int dir=0; dir<6; dir++) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=N||nc<0||nc>=N) continue;
				if(dist[nr][nc]>-1) continue;
				q.add(new int[] {nr,nc});
				dist[nr][nc]=dist[cur[0]][cur[1]]+1;
			}
		}
	}
}