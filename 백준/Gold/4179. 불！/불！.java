import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int R,C;
	static char[][] maze;
	static Queue<int[]> jihoon = new ArrayDeque<>();
	static Queue<int[]> fire = new ArrayDeque<>();
	static int[][] dist_ji, dist_fire;
	static final int[] dr = {-1,1,0,0};
	static final int[] dc = {0,0,-1,1};
 	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		maze = new char[R][C];
		dist_ji = new int[R][C];
		dist_fire = new int[R][C];
		for(int[] r : dist_ji) Arrays.fill(r, -1);
		for(int[] r : dist_fire) Arrays.fill(r, -1);
		for(int r=0; r<R; r++) {
			String line = br.readLine();
			for(int c=0; c<C; c++) {
				maze[r][c] = line.charAt(c);
				if(maze[r][c]=='J') {
					jihoon.offer(new int[] {r,c});
					dist_ji[r][c]=0;
				}
				if(maze[r][c]=='F') {
					fire.offer(new int[] {r,c});
					dist_fire[r][c]=0;
				}
			}
		}
		while(!fire.isEmpty()) {
			int[] cur = fire.poll();
			for(int dir=0; dir<4; dir++) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=R||nc<0||nc>=C) continue;
				if(maze[nr][nc]=='#'||dist_fire[nr][nc]>-1) continue;
				dist_fire[nr][nc]=dist_fire[cur[0]][cur[1]]+1;
				fire.offer(new int[] {nr,nc});
			}
		}
		while(!jihoon.isEmpty()) {
			int[] cur = jihoon.poll();
			for(int dir=0; dir<4; dir++) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=R||nc<0||nc>=C) {
					bw.write(dist_ji[cur[0]][cur[1]]+1+"");
					bw.close();
					br.close();
					return;
				}
				if(maze[nr][nc]=='#'||dist_ji[nr][nc]>-1) continue;
				if(dist_fire[nr][nc]!=-1&&dist_ji[cur[0]][cur[1]]+1>=dist_fire[nr][nc]) continue;
				dist_ji[nr][nc]=dist_ji[cur[0]][cur[1]]+1;
				jihoon.offer(new int[] {nr,nc});
				
			}
		}
		bw.write("IMPOSSIBLE");
		bw.close();
		br.close();
		return;
	}
}