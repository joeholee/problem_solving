import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,M,ans;
	static int[][] map;
	static int[][][] dist; // 벽 부쉈는지 여부
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[] cur;
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		String[] sz = br.readLine().split(" ");
		N = Integer.parseInt(sz[0]);
		M = Integer.parseInt(sz[1]);
		map = new int[N][M];
		dist = new int[N][M][2];
		for(int r=0; r<N; r++) {
			String row = br.readLine();
			for(int c=0; c<M; c++) map[r][c]=row.charAt(c)-'0';
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) Arrays.fill(dist[r][c],-1);
		}
		ans=-1;
		bfs();
		System.out.println(ans);
	}
	
	static void bfs() {
		q.add(new int[] {0,0,0});
		dist[0][0][0]=1;
		dist[0][0][1]=1;
		while(!q.isEmpty()) {
			cur = q.poll();
			if(cur[0]==N-1 && cur[1]==M-1) {
				ans=dist[cur[0]][cur[1]][cur[2]];
				return;
			}
			for(int dir=0; dir<4; dir++) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=N||nc<0||nc>=M) continue;
				if(dist[nr][nc][cur[2]]>0) continue;
				if(map[nr][nc]==0) {
					dist[nr][nc][cur[2]]=dist[cur[0]][cur[1]][cur[2]]+1;
					q.add(new int[] {nr,nc,cur[2]});
				}
				if(map[nr][nc]==1 && cur[2]==0) {
					dist[nr][nc][1]=dist[cur[0]][cur[1]][cur[2]]+1;
					q.add(new int[] {nr,nc,1});
				}
			}
		}
	}
}