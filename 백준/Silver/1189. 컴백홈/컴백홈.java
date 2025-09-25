import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int R,C,K,ans;
	static char[][] arr;
	static boolean[][] vis;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		for(int r=0; r<R; r++) {
			String line = br.readLine();
			for(int c=0; c<C; c++) arr[r][c] = line.charAt(c);
		}
		vis = new boolean[R][C];
		vis[R-1][0]=true;
		dfs(R-1,0,1);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void dfs(int r, int c, int dist) {
		if(dist>K) return;
		if(r==0 && c==C-1) {
			if(dist==K) ans++;
			return;
		}
		for(int dir=0; dir<4; dir++) {
			int nr = r+dr[dir];
			int nc = c+dc[dir];
			if(nr<0||nr>=R||nc<0||nc>=C) continue;
			if(arr[nr][nc]=='T'||vis[nr][nc]) continue;
			vis[nr][nc]=true;
			dfs(nr,nc,dist+1);
			vis[nr][nc]=false;
		}
	}
}