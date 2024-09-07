import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,max,ans;
	static int[] cur;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] height;
	static boolean[][] vis;
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		height = new int[N][N];
		vis = new boolean[N][N];
		for(int r=0; r<N; r++) {
			String[] row = br.readLine().split(" ");
			for(int c=0; c<N; c++) {
				height[r][c]=Integer.parseInt(row[c]);
				if(height[r][c]>max) max=height[r][c];
			}
		}
		for(int i=0; i<=max; i++) {
			drain(i);
			bfs();
		}
		System.out.println(ans);
	}
	
	static void drain(int lvl) {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(height[r][c]<=lvl) height[r][c]=0;
			}
		}
	}
	
	static void bfs() {
		int tmp=0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(height[r][c]!=0 && !vis[r][c]) {
					q.add(new int[] {r,c});
					vis[r][c]=true;
					while(!q.isEmpty()) {
						cur = q.poll();
						for(int dir=0; dir<4; dir++) {
							int nr = cur[0]+dr[dir];
							int nc = cur[1]+dc[dir];
							if(nr<0||nr>=N||nc<0||nc>=N) continue;
							if(vis[nr][nc]||height[nr][nc]==0) continue;
							vis[nr][nc]=true;
							q.add(new int[] {nr,nc});
						}
					}
					tmp++;
				}
			}
		}
		ans = Integer.max(ans,tmp);
		for(boolean[] v : vis) Arrays.fill(v,false);
	}
}