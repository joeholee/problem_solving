import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int r,c,cheese,cnt,time;
	static int[][] arr;
	static boolean[][] vis;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[r][c];
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) cheese++;
			}
		}
		while(cheese>0) {
			cnt = cheese;
			time++;
			vis = new boolean[r][c];
			bfs();
		}
		sb.append(time).append('\n').append(cnt);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0,0});
		vis[0][0] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int dir=0; dir<4; dir++) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=r||nc<0||nc>=c) continue;
				if(vis[nr][nc]) continue;
				vis[nr][nc] = true;
				if(arr[nr][nc]==0) q.offer(new int[] {nr,nc});
				else {
					cheese--;
					arr[nr][nc]=0;
				}
			}
		}
	}
}