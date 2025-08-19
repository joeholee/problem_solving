import java.io.*;
import java.util.*;

public class Main {
	static class Virus implements Comparable<Virus> {
		int r,c,type;
		
		Virus(int r, int c, int type) {
			this.r=r;
			this.c=c;
			this.type=type;
		}
		
		@Override
		public int compareTo(Virus v) {
			return Integer.compare(type, v.type);
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] board;
	static boolean[][] vis;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int N,K,S,X,Y,sec;
	static PriorityQueue<Virus> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		vis = new boolean[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) board[r][c] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		bfs(0);
		bw.write(board[X-1][Y-1]+"");
		bw.close();
		br.close();
	}
	
	static void bfs(int sec) {
		if(sec==S) return;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(board[r][c]!=0 && !vis[r][c]) pq.add(new Virus(r,c,board[r][c]));
			}
		}
		while(!pq.isEmpty()) {
			Virus cur = pq.poll();
			vis[cur.r][cur.c]=true;
			for(int dir=0; dir<4; dir++) {
				int nr = cur.r+dr[dir];
				int nc = cur.c+dc[dir];
				if(nr<0||nr>=N||nc<0||nc>=N) continue;
				if(board[nr][nc]!=0) continue;
				board[nr][nc]=cur.type;
			}
		}
		bfs(sec+1);
	}
}