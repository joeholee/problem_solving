import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int K,W,H,ans;
	static int[][] grid;
	static boolean[][][] vis;
	static int[] cur;
	static int[] dr = {-1,0,1,0,-2,-1,1,2,2,1,-1,-2};
	static int[] dc = {0,1,0,-1,1,2,2,1,-1,-2,-2,-1};
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		grid = new int[H][W];
		vis = new boolean[H][W][K+1];
		for(int r=0; r<H; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<W; c++) grid[r][c]=Integer.parseInt(st.nextToken());
		}
		ans=-1;
		bfs();
		System.out.println(ans);
	}
	
	static void bfs() {
		q.add(new int[] {0,0,0,0});
		vis[0][0][0]=true;
		while(!q.isEmpty()) {
			cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int horse = cur[2];
			int mv = cur[3];
			
			if(r==H-1 && c==W-1) {
				ans=mv;
				return;
			}
			if(horse<K) {
				for(int dir=4; dir<12; dir++) {
					int nr = r+dr[dir];
					int nc = c+dc[dir];
					if(nr<0||nr>=H||nc<0||nc>=W) continue;
					if(vis[nr][nc][horse+1]) continue;
					if(grid[nr][nc]==1) continue;
					vis[nr][nc][horse+1]=true;
					q.add(new int[] {nr,nc,horse+1,mv+1});
				}
			}
			for(int dir=0; dir<4; dir++) {
				int nr=r+dr[dir];
				int nc=c+dc[dir];
				if(nr<0||nr>=H||nc<0||nc>=W) continue;
				if(vis[nr][nc][horse]) continue;
				if(grid[nr][nc]==1) continue;
				vis[nr][nc][horse]=true;
				q.add(new int[] {nr,nc,horse,mv+1});
			}
		}
	}
}