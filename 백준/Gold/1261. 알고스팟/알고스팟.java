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
		dijkstra();
		bw.write(wall[N-1][M-1]+"");
		bw.close();
		br.close();
	}
	
	static void dijkstra() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		wall[0][0]=0;
		pq.offer(new Point(0,0,0));
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			if(wall[cur.r][cur.c]!=cur.cnt) continue;
			for(int dir=0; dir<4; dir++) {
				int nr = cur.r+dr[dir];
				int nc = cur.c+dc[dir];
				if(nr<0||nr>=N||nc<0||nc>=M) continue;
				int w = (arr[nr][nc]=='1') ? 1 : 0;
				if(wall[nr][nc]>cur.cnt+w) {
					wall[nr][nc] = cur.cnt+w;
					pq.offer(new Point(nr,nc,wall[nr][nc]));
				}
			}
		}
	}
	
	static class Point implements Comparable<Point> {
		int r,c,cnt;
		
		Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Point p) {
			return Integer.compare(cnt, p.cnt);
		}
	}
}