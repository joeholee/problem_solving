import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int R,C;
	static char[][] yard;
	static boolean[][] vis;
	static int sheep,wolf;
	static int[] cur;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		yard = new char[R][C];
		vis = new boolean[R][C];
		for(int r=0; r<R; r++) {
			char[] row = br.readLine().toCharArray();
			for(int c=0; c<C; c++) yard[r][c]=row[c];
		}
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(yard[r][c]!='.' && yard[r][c]!='#' && !vis[r][c]) solve(r,c);
			}
		}
		sb.append(sheep).append(" ").append(wolf);
		System.out.println(sb);
	}
	static void solve(int r, int c) {
		int tmpSheep=0, tmpWolf=0;
		vis[r][c]=true;
		q.add(new int[] {r,c});
		while(!q.isEmpty()) {
			cur = q.poll();
			if(yard[cur[0]][cur[1]]=='o') tmpSheep++;
			else if(yard[cur[0]][cur[1]]=='v')tmpWolf++;
			for(int dir=0; dir<4; dir++) {
				int nr=cur[0]+dr[dir];
				int nc=cur[1]+dc[dir];
				if(nr<0||nr>=R||nc<0||nc>=C) continue;
				if(vis[nr][nc]) continue;
				if(yard[nr][nc]=='#') continue;
				vis[nr][nc]=true;
				q.add(new int[] {nr,nc});
			}
		}
		if(tmpSheep>tmpWolf) tmpWolf=0;
		else tmpSheep=0;
		sheep+=tmpSheep;
		wolf+=tmpWolf;
	}
}