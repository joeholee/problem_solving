import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {
	static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,max,ans;
	static int[][] area;
	static boolean[][] vis;
	static int[] cur;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		area = new int[N][N];
		vis = new boolean[N][N];
		max=Integer.MIN_VALUE;
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				area[r][c]=Integer.parseInt(st.nextToken());
				max = Math.max(max,area[r][c]);
			}
		}
		ans=1;
		for(int i=0; i<=max; i++) solve(i);
		System.out.println(ans);
	}
	
	static void solve(int height) {
		int cnt=0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(area[r][c]<=height || vis[r][c]) continue;
				vis[r][c]=true;
				q.add(new int[] {r,c});
				cnt++;
				while(!q.isEmpty()) {
					cur = q.poll();
					for(int dir=0; dir<4; dir++) {
						int nr = cur[0]+dr[dir];
						int nc = cur[1]+dc[dir];
						if(nr<0||nr>=N||nc<0||nc>=N) continue;
						if(area[nr][nc]<=height || vis[nr][nc]) continue;
						vis[nr][nc]=true;
						q.add(new int[] {nr,nc});
					}
				}
			}
		}
		ans = Math.max(ans, cnt);
		for(boolean[] row : vis) Arrays.fill(row, false);
	}
}