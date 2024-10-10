import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M,ans;
	static int[][] cheese;
	static boolean[][] vis;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[] cur;
	
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheese = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				cheese[r][c]=Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			vis = new boolean[N][M];
			checkAir(0,0);
			boolean update=false;
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(cheese[r][c]==1 && checkMelt(r,c)) {
						cheese[r][c]=0;
						update=true;
					}
				}
			}
			if(!update) break;
			ans++;
		}
		System.out.println(ans);
	}
	
	static void checkAir(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c});
		vis[r][c]=true;
		cheese[r][c]=2;
		while(!q.isEmpty()) {
			cur = q.poll();
			for(int dir=0; dir<4; dir++) {
				int nr=cur[0]+dr[dir];
				int nc=cur[1]+dc[dir];
				if(nr<0||nr>=N||nc<0||nc>=M) continue;
				if(vis[nr][nc]) continue;
				if(cheese[nr][nc]==1) continue;
				vis[nr][nc]=true;
				cheese[nr][nc]=2;
				q.add(new int[] {nr,nc});
			}
		}
	}
	
	static boolean checkMelt(int r, int c) {
		int cnt=0;
		for(int dir=0; dir<4; dir++) {
			int nr=r+dr[dir];
			int nc=c+dc[dir];
			if(nr>=0 && nr<N && nc>=0 && nc<M && cheese[nr][nc]==2) {
				cnt++;
			}
		}
		return cnt>=2;
	}
}