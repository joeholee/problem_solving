import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int R,C;
	static int ans = Integer.MAX_VALUE;
	static char[][] arr;
	static Queue<int[]> q = new ArrayDeque<>();
	static Queue<int[]> water = new ArrayDeque<>();
	static final int[] dr = {-1,0,1,0};
	static final int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		for(int r=0; r<R; r++) {
			String input = br.readLine();
			for(int c=0; c<C; c++) {
				arr[r][c] = input.charAt(c);
				if(arr[r][c]=='*') water.add(new int[] {r,c});
				if(arr[r][c]=='S') q.add(new int[] {r,c,0});
			}
		}
		solve();
		sb.append(ans==Integer.MAX_VALUE ? "KAKTUS" : ans);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void solve() {
		while(!q.isEmpty()) {
			int wlen = water.size();
			for(int i=0; i<wlen; i++) {
				int[] cur = water.poll();
				for(int dir=0; dir<4; dir++) {
					int nr = cur[0]+dr[dir];
					int nc = cur[1]+dc[dir];
					if(nr<0||nr>=R||nc<0||nc>=C) continue;
					if(arr[nr][nc]=='X'||arr[nr][nc]=='D'||arr[nr][nc]=='*') continue;
					arr[nr][nc]='*';
					water.offer(new int[] {nr,nc});
				}
			}
			int len = q.size();
			for(int i=0; i<len; i++) {
				int[] cur = q.poll();
				for(int dir=0; dir<4; dir++) {
					int nr = cur[0]+dr[dir];
					int nc = cur[1]+dc[dir];
					if(nr<0||nr>=R||nc<0||nc>=C) continue;
					if(arr[nr][nc]=='*'||arr[nr][nc]=='X') continue;
					if(arr[nr][nc]=='D') {
						ans = Math.min(ans, cur[2]+1);
						return;
					}
					if(arr[nr][nc]=='.') {
						arr[nr][nc]='S';
						q.offer(new int[] {nr,nc,cur[2]+1});
					}
				}
			}
		}
	}
}