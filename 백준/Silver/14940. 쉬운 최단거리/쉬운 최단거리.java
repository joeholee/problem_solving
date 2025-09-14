import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n,m,sR,sC;
	static int[][] arr,dist;
	static Queue<int[]> q = new ArrayDeque<>();
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for(int r=0; r<n; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<m; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if(arr[r][c]==2) {
					sR = r;
					sC = c;
				}
			}
		}
		dist = new int[n][m];
		for(int[] r : dist) Arrays.fill(r,-1);
		dist[sR][sC] = 0;
		q.offer(new int[] {sR,sC});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int dir=0; dir<4; dir++) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=n||nc<0||nc>=m) continue;
				if(dist[nr][nc]!=-1) continue;
				if(arr[nr][nc]==0) continue;
				dist[nr][nc] = dist[cur[0]][cur[1]]+1;
				q.offer(new int[] {nr,nc});
			}
		}
		for(int r=0; r<n; r++) {
			for(int c=0; c<m; c++) {
				if(arr[r][c]==0) sb.append(0).append(' ');
				else sb.append(dist[r][c]).append(' ');
			}
			sb.append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}