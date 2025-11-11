import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n,m,pic,max;
	static int[][] arr;
	static boolean[][] vis;
	static final int[] dr = {-1,0,1,0};
	static final int[] dc = {0,1,0,-1};
 	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for(int r=0; r<n; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<m; c++) arr[r][c] = Integer.parseInt(st.nextToken());
		}
		vis = new boolean[n][m];
		for(int r=0; r<n; r++) {
			for(int c=0; c<m; c++) {
				if(!vis[r][c]&&arr[r][c]==1) {
					pic++;
					bfs(r,c);
				}
			}
		}
		sb.append(pic).append('\n').append(max);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void bfs(int r, int c) {
		int tmp = 1;
		vis[r][c]=true;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r,c});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int dir=0; dir<4; dir++) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=n||nc<0||nc>=m) continue;
				if(vis[nr][nc]||arr[nr][nc]==0) continue;
				vis[nr][nc]=true;
				tmp++;
				q.offer(new int[] {nr,nc});
			}
		}
		max = Math.max(max, tmp);
	}
}