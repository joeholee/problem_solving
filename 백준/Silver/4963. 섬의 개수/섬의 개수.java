import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int w,h,cnt;
	static int[] dr = {-1,-1,-1,0,1,1,1,0};
	static int[] dc = {-1,0,1,1,1,0,-1,-1};
	static int[][] map;
	static boolean[][] vis;
	
	public static void main(String[] args) throws IOException {
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w==0&&h==0) break;
			map = new int[h][w];
			vis = new boolean[h][w];
			cnt=0;
			for(int r=0; r<h; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<w; c++) map[r][c]=Integer.parseInt(st.nextToken());
			}
			for(int r=0; r<h; r++) {
				for(int c=0; c<w; c++) {
					if(map[r][c]==1&&!vis[r][c]) {
						cnt++;
						bfs(r,c);
					}
				}
			}
			sb.append(cnt).append('\n');
		}
		System.out.println(sb);
	}
	
	static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r,c});
		vis[r][c]=true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int dir=0; dir<8; dir++) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=h||nc<0||nc>=w) continue;
				if(map[nr][nc]==0||vis[nr][nc]) continue;
				vis[nr][nc]=true;
				q.add(new int[] {nr,nc});
			}
		}
	}
}