import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M;
	static char[][] arr;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[] cur;
	static int dist = Integer.MAX_VALUE;
	
	static class State {
		int r,c,keys,dist;
		
		State(int r, int c, int keys, int dist) {
			this.r = r;
			this.c = c;
			this.keys = keys;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		for(int r=0; r<N; r++) {
			String line = br.readLine();
			for(int c=0; c<M; c++) {
				arr[r][c] = line.charAt(c);
				if(arr[r][c]=='0') cur = new int[] {r,c};
			}
		}
		bfs(cur[0],cur[1]);
		dist = (dist==Integer.MAX_VALUE) ? -1 : dist;
		bw.write(dist+"");
		bw.close();
		br.close();
	}
	
	static void bfs(int r, int c) {
		Queue<State> q = new ArrayDeque<>();
		boolean[][][] vis = new boolean[N][M][1<<6];
		q.offer(new State(r,c,0,0));
		vis[r][c][0]=true;
		while(!q.isEmpty()) {
			State cur = q.poll();
			if(arr[cur.r][cur.c]=='1') {
				dist = Math.min(dist, cur.dist);
				return;
			}
			for(int dir=0; dir<4; dir++) {
				int nr = cur.r+dr[dir];
				int nc = cur.c+dc[dir];
				int keys = cur.keys;
				if(nr<0||nr>=N||nc<0||nc>=M) continue;
				if(arr[nr][nc]=='#') continue;
				if('a'<=arr[nr][nc]&&arr[nr][nc]<='f') keys|=(1<<(arr[nr][nc]-'a'));
				if('A'<=arr[nr][nc]&&arr[nr][nc]<='F') {
					if((keys&(1<<(arr[nr][nc]-'A')))==0) continue;
				}
				if(!vis[nr][nc][keys]) {
					vis[nr][nc][keys]=true;
					q.offer(new State(nr,nc,keys,cur.dist+1));
				}
			}
		}
	}
}