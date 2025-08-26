import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M;
	static final int[] dr = {-1,0,1,0};
	static final int[] dc = {0,1,0,-1};
	static final int INF = Integer.MAX_VALUE;
	static char[][] arr;
	static int[][] wall;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		wall = new int[N][M];
		for(int i=0; i<N; i++) Arrays.fill(wall[i], INF);
		for(int r=0; r<N; r++) {
			char[] input = br.readLine().toCharArray();
			for(int c=0; c<M; c++) arr[r][c] = input[c];
		}
		bfs();
		bw.write(wall[N-1][M-1]+"");
		bw.close();
		br.close();
	}
	
	static void bfs() {
		Deque<int[]> dq = new ArrayDeque<>();
		wall[0][0] = 0;
		dq.add(new int[] {0,0});
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			for(int dir=0; dir<4; dir++) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=N||nc<0||nc>=M) continue;
				int w = (arr[nr][nc]=='1') ? 1 : 0;
				if(wall[nr][nc]>wall[cur[0]][cur[1]]+w) {
					wall[nr][nc]=wall[cur[0]][cur[1]]+w;
					if(w==0) dq.addFirst(new int[] {nr,nc});
					else dq.add(new int[] {nr,nc});
				}
			}
		}
	}
}