import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int ans = Integer.MIN_VALUE;
	static int[][] map;
	static int[][] virusMap;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) map[r][c] = Integer.parseInt(st.nextToken());
		}
		dfs(0);
		System.out.println(ans);
	}
	
	// 벽 세우기
	static void dfs(int wall) {
		if(wall==3) {
			bfs();
			return;
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c]==0) {
					map[r][c]=1;
					dfs(wall+1);
					map[r][c]=0;
				}
			}
		}
	}
	
	// 바이러스
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		virusMap = new int[N][M];
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				virusMap[r][c] = map[r][c];
				if(virusMap[r][c]==2) q.add(new int[] {r,c});
			}
		}
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int dir=0; dir<4; dir++) {
				int nr = cur[0] + dr[dir];
				int nc = cur[1] + dc[dir];
				if(nr<0||nr>=N||nc<0||nc>=M) continue;
				if(virusMap[nr][nc]==0) {
					virusMap[nr][nc]=2;
					q.add(new int[] {nr,nc});
				}
			}
		}
		int tmp = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(virusMap[r][c]==0) tmp++;
			}
		}
		ans = Math.max(ans,tmp);
	}
}