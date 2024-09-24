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
	static int N,M,ans;
	static char[][] map;
	static int[][][] dist;
	static int[] cur;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		dist = new int[N][M][2];
		for(int r=0; r<N; r++) {
			char[] input = br.readLine().toCharArray();
			for(int c=0; c<M; c++) map[r][c]=input[c];
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) Arrays.fill(dist[r][c], -1);
		}
		ans=-1;
		bfs();
		System.out.println(ans);
	}
	
	static void bfs() {
		q.add(new int[] {0,0,0});
		dist[0][0][0]=dist[0][0][1]=1;
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
				if(map[nr][nc]=='0') {
					dist[nr][nc][cur[2]]=dist[cur[0]][cur[1]][cur[2]]+1;
					q.add(new int[] {nr,nc,cur[2]});
				}
				if(map[nr][nc]=='1' && cur[2]==0) {
					dist[nr][nc][1]=dist[cur[0]][cur[1]][0]+1;
					q.add(new int[] {nr,nc,1});
				}
			}
		}
	}
}