import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M,ans;
	static int[] cur;
	static char[][] floor;
	static boolean[][] vis;
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		floor = new char[N][M];
		vis = new boolean[N][M];
		for(int r=0; r<N; r++) {
			char[] row = br.readLine().toCharArray();
			for(int c=0; c<M; c++) floor[r][c]=row[c];
		}
		solve();
		System.out.println(ans);
	}
	
	static void solve() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(!vis[r][c] && floor[r][c]=='-') {
					q.add(new int[] {r,c});
					vis[r][c]=true;
					while(!q.isEmpty()) {
						cur = q.poll();
						int nc=cur[1]+1;
						if(nc<M && !vis[r][nc] && floor[r][nc]=='-') {
							q.add(new int[] {r,nc});
							vis[r][nc]=true;
						}
					}
					ans++;
				}
				if(!vis[r][c] && floor[r][c]=='|') {
					q.add(new int[] {r,c});
					vis[r][c]=true;
					while(!q.isEmpty()) {
						cur = q.poll();
						int nr=cur[0]+1;
						if(nr<N && !vis[nr][c] && floor[nr][c]=='|') {
							q.add(new int[] {nr,c});
							vis[nr][c]=true;
						}
					}
					ans++;
				}
			}
		}
	}
}