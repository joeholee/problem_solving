import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static char[][] arr = new char[5][5];
	static int[] pick = new int[7];
	static int ans;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		for(int r=0; r<5; r++) {
			String line = br.readLine();
			for(int c=0; c<5; c++) arr[r][c] = line.charAt(c);
		}
		dfs(0,0,0);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void dfs(int idx, int cnt, int yCnt) {
		if(yCnt>=4) return;
		if(cnt==7) {
			bfs();
			return;
		}
		for(int i=idx; i<25; i++) {
			pick[cnt] = i;
			if(arr[i/5][i%5]=='Y') dfs(i+1,cnt+1,yCnt+1);
			else dfs(i+1,cnt+1,yCnt);
		}
	}
	
	static void bfs() {
		int con = 1;
		boolean[] vis = new boolean[7];
		Queue<int[]> q = new ArrayDeque<>();
		vis[0] = true;
		q.offer(new int[] {pick[0]/5, pick[0]%5});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int dir=0; dir<4; dir++) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=5||nc<0||nc>=5) continue;
				for(int i=0; i<7; i++) {
					if(!vis[i]&&pick[i]==nr*5+nc) {
						q.offer(new int[] {nr,nc});
						vis[i]=true;
						con++;
					}
				}
			}
		}
		if(con==7) ans++;
	}
}