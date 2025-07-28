import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static int[][] maze;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		for(int i=0; i<N; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0; j<M; j++) maze[i][j]=line[j]-'0';
		}
		solve();
		System.out.println(maze[N-1][M-1]+1);
	}
	
	static void solve() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0,0});
		maze[0][0]=0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int dir=0; dir<4; dir++) {
				int nr=cur[0]+dr[dir];
				int nc=cur[1]+dc[dir];
				if(nr<0||nr>=N||nc<0||nc>=M) continue;
				if(maze[nr][nc]!=1) continue;
				q.offer(new int[] {nr,nc});
				maze[nr][nc] = maze[cur[0]][cur[1]]+1;
			}
		}
	}
}