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
	static int N,M,K,ans;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[] cur;
	static char[][] map;
	static int[][][] dist; // 마지막은 벽 부순 개수
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int r=0; r<N; r++) {
			char[] row = br.readLine().toCharArray();
			for(int c=0; c<M; c++) map[r][c]=row[c];
		}
		dist = new int[N][M][K+1];
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) Arrays.fill(dist[r][c], -1);
		}
		dist[0][0][0]=1;
		ans=-1;
		bfs();
		System.out.println(ans);
	}
	
	static void bfs() {
		q.add(new int[] {0,0,0});
		while(!q.isEmpty()) {
			cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int wall = cur[2];
			if(cur[0]==N-1 && cur[1]==M-1) {
				ans=dist[r][c][wall];
				return;
			}
			for(int dir=0; dir<4; dir++) {
				int nr = r+dr[dir];
				int nc = c+dc[dir];
				if(nr<0||nr>=N||nc<0||nc>=M) continue;
				if(dist[nr][nc][wall]>0) continue;
				if(map[nr][nc]=='0' && dist[nr][nc][wall]==-1) {
					dist[nr][nc][wall]=dist[r][c][wall]+1;
					q.add(new int[] {nr,nc,wall});
				}
				if(map[nr][nc]=='1' && wall<K && dist[nr][nc][wall+1]==-1) {
					dist[nr][nc][wall+1]=dist[r][c][wall]+1;
					q.add(new int[] {nr,nc,wall+1});
				}
			}
		}
	}
}