import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static char[][] room;
	static final int[] dr = {-1,0,1,0};
	static final int[] dc = {0,1,0,-1};
	static int[][] dist;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		room = new char[n][n];
		for(int r=0; r<n; r++) {
			char[] input = br.readLine().toCharArray();
			for(int c=0; c<n; c++) room[r][c] = input[c];
		}
		dist = new int[n][n];
		for(int r=0; r<n; r++) Arrays.fill(dist[r], INF);
		bfs();
		bw.write(dist[n-1][n-1]+"");
		bw.close();
		br.close();
	}
	
	static void bfs() {
		Deque<int[]> dq = new ArrayDeque<>();
		dist[0][0] = 0;
		dq.offerFirst(new int[] {0,0});
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			for(int dir=0; dir<4; dir++) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=n||nc<0||nc>=n) continue;
				int d = (room[nr][nc]=='1') ? 0 : 1;
				if(dist[nr][nc]>dist[cur[0]][cur[1]]+d) {
					dist[nr][nc]=dist[cur[0]][cur[1]]+d;
					if(d==0) dq.offerFirst(new int[] {nr,nc});
					else dq.offer(new int[] {nr,nc});
				}
			}
		}
	}
}