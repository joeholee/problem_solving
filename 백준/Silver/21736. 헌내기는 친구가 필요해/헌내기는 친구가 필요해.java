import java.io.*;
import java.util.*;

public class Main {
	static int N,M,startR,startC,ans;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static char[][] campus;
	static boolean[][] vis;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		campus = new char[N][M];
		vis = new boolean[N][M];
		for(int r=0; r<N; r++) {
			String input = br.readLine();
			for(int c=0; c<M; c++) {
				campus[r][c]=input.charAt(c);
				if(campus[r][c]=='I') {
					startR=r; startC=c;
				}
			}
		}
		bfs(startR, startC);
		sb.append(ans == 0 ? "TT" : ans);
		System.out.println(sb);
	}
	
	static void bfs(int r, int c) {
		int[] cur = new int[] {r,c};
		Queue<int[]> q = new LinkedList<>();
		vis[r][c]=true;
		q.add(cur);
		while(!q.isEmpty()) {
			cur = q.poll();
			for(int dir=0; dir<4; dir++) {
				int nr=cur[0]+dr[dir];
				int nc=cur[1]+dc[dir];
				if(nr<0||nr>=N||nc<0||nc>=M) continue;
				if(vis[nr][nc]||campus[nr][nc]=='X') continue;
				if(campus[nr][nc]=='P') ans++;
				vis[nr][nc]=true;
				q.add(new int[] {nr,nc});
			}
		}
	}
} 