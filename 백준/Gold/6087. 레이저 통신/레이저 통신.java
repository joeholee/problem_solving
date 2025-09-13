import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int W,H,ans=Integer.MAX_VALUE;
	static char[][] arr;
	static List<int[]> grids = new ArrayList<>();
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new char[H][W];
		for(int r=0; r<H; r++) {
			String line = br.readLine();
			for(int c=0; c<W; c++) {
				arr[r][c] = line.charAt(c);
				if(arr[r][c]=='C') grids.add(new int[] {r,c});
			}
		}
		bfs(grids.get(0), grids.get(1));
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void bfs(int[] start, int[] end) {
		int[][][] dist = new int[H][W][4];
		for(int[][] a : dist) {
			for(int[] b : a) Arrays.fill(b, Integer.MAX_VALUE);
		}
		Deque<int[]> dq = new ArrayDeque<>();
		for(int dir=0; dir<4; dir++) {
			dist[start[0]][start[1]][dir] = 0;
			dq.add(new int[] {start[0],start[1],dir});
		}
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			int r = cur[0], c = cur[1], dir = cur[2];
			int cost = dist[r][c][dir];
			int nr = r+dr[dir], nc = c+dc[dir];
			if(nr<0||nr>=H||nc<0||nc>=W) continue;
			if(arr[nr][nc]=='*') continue;
			if(dist[nr][nc][dir]>cost) {
				dist[nr][nc][dir] = cost;
				dq.addFirst(new int[] {nr,nc,dir});
			}
			for(int ndir = 0; ndir<4; ndir++) {
				if(ndir==dir||(dir%2==ndir%2)) continue;
				if(dist[nr][nc][ndir]>cost+1) {
					dist[nr][nc][ndir]=cost+1;
					dq.addLast(new int[] {nr,nc,ndir});
				}
			}
		}
		for(int dir=0; dir<4; dir++) ans = Math.min(ans, dist[end[0]][end[1]][dir]);
	}
}