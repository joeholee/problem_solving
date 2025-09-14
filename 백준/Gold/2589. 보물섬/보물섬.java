import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int R,C,ans=Integer.MIN_VALUE;
	static char[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int r=0; r<R; r++) {
			String line = br.readLine();
			for(int c=0; c<C; c++) map[r][c] = line.charAt(c);
		}
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c]=='L') bfs(r,c);
			}
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void bfs(int r, int c) {
		boolean[][] vis = new boolean[R][C];
		int[][] dist = new int[R][C];
		Queue<int[]> q = new ArrayDeque<>();
		vis[r][c] = true;
		int tmp = Integer.MIN_VALUE;
		q.offer(new int[] {r,c});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int dir=0; dir<4; dir++) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=R||nc<0||nc>=C) continue;
				if(map[nr][nc]=='W'||vis[nr][nc]) continue;
				vis[nr][nc]=true;
				dist[nr][nc]=dist[cur[0]][cur[1]]+1;
				q.offer(new int[] {nr,nc});
			}
		}
		for(int rdx=0; rdx<R; rdx++) {
			for(int cdx=0; cdx<C; cdx++) {
				tmp = Math.max(tmp, dist[rdx][cdx]);
			}
		}
		ans = Math.max(ans, tmp);
	}
}