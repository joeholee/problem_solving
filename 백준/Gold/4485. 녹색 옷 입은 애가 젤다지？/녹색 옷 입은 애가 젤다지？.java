import java.io.*;
import java.util.*;

public class Main {
	
	static class Node implements Comparable<Node> {
		int r,c,weight;
		
		Node(int r, int c, int weight) {
			this.r=r;
			this.c=c;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Node n) {
			return Integer.compare(weight, n.weight);
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,p;
	static int[][] board,dist;
	static PriorityQueue<Node> pq;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			p++;
			board = new int[N][N];
			dist = new int[N][N];
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) board[r][c] = Integer.parseInt(st.nextToken());
				Arrays.fill(dist[r], INF);
			}
			dijkstra();
			sb.append("Problem ").append(p).append(": ").append(dist[N-1][N-1]).append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void dijkstra() {
		pq = new PriorityQueue<>();
		dist[0][0] = board[0][0];
		pq.add(new Node(0,0,dist[0][0]));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(cur.weight!=dist[cur.r][cur.c]) continue;
			if(cur.r==N-1 && cur.c==N-1) break;
			for(int dir=0; dir<4; dir++) {
				int nr = cur.r+dr[dir];
				int nc = cur.c+dc[dir];
				if(nr<0||nr>=N||nc<0||nc>=N) continue;
				if(dist[nr][nc]>dist[cur.r][cur.c]+board[nr][nc]) {
					dist[nr][nc]=dist[cur.r][cur.c]+board[nr][nc];
					pq.add(new Node(nr,nc,dist[nr][nc]));
				}
			}
		}
	}
}