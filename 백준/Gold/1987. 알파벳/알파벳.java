import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int R,C,ans;
	static char[][] arr;
	static boolean[] vis;
	static final int[] dr = {-1,0,1,0};
	static final int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		vis = new boolean[26];
		for(int r=0; r<R; r++) {
			String line = br.readLine();
			for(int c=0; c<C; c++) arr[r][c] = line.charAt(c);
		}
		vis[arr[0][0]-'A']=true;
		dfs(0,0,1);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void dfs(int r, int c, int cnt) {
		ans = Math.max(ans, cnt);
		for(int dir=0; dir<4; dir++) {
			int nr = r+dr[dir];
			int nc = c+dc[dir];
			if(nr<0||nr>=R||nc<0||nc>=C) continue;
			int idx = arr[nr][nc]-'A';
			if(!vis[idx]) {
				vis[idx]=true;
				dfs(nr,nc,cnt+1);
				vis[idx]=false;
			}
		}
	}
}