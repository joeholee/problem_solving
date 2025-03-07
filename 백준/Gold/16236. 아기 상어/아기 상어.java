import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1,0,0,1};
	static int[] dc = {0,-1,1,0};
	static int[][] grid;
	static boolean[][] vis;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] sharkCur;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				grid[r][c] = Integer.parseInt(st.nextToken());
				if(grid[r][c]==9) {
					sharkCur = new int[] {r,c};
					grid[r][c]=0;
				}
			}
		}
		int curSize = 2;
		int fish = 0;
		int dist = 0;
		while(true) {
			vis = new boolean[N][N];
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) ->
			o1[2]!=o2[2] ? Integer.compare(o1[2],o2[2]) : 
				(o1[0]!=o2[0] ? Integer.compare(o1[0],o2[0]) : Integer.compare(o1[1],o2[1]))
					);
			pq.add(new int[] {sharkCur[0],sharkCur[1],0});
			vis[sharkCur[0]][sharkCur[1]]=true;
			boolean eat = false;
			while(!pq.isEmpty()) {
				sharkCur = pq.poll();
				if(grid[sharkCur[0]][sharkCur[1]]!=0 && grid[sharkCur[0]][sharkCur[1]]<curSize) {
					grid[sharkCur[0]][sharkCur[1]]=0;
					fish++;
					dist+=sharkCur[2];
					eat=true;
					break;
				}
				for(int dir=0; dir<4; dir++) {
					int nr = sharkCur[0]+dr[dir];
					int nc = sharkCur[1]+dc[dir];
					if(nr<0||nr>=N||nc<0||nc>=N||vis[nr][nc]||grid[nr][nc]>curSize) continue;
					pq.add(new int[] {nr,nc,sharkCur[2]+1});
					vis[nr][nc]=true;
				}
			}
			if(!eat) break;
			if(curSize==fish) {
				curSize++;
				fish=0;
			}
		}
		System.out.println(dist);
	}
}