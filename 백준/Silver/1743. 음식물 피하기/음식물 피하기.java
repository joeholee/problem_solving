import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M,K,ans;
	static int[][] arr;
	static boolean[][] vis;
	static List<int[]> li = new ArrayList<>();
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[r-1][c-1] = 1;
			li.add(new int[] {r-1,c-1});
		}
		vis = new boolean[N][M];
		solve();
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void solve() {
		for(int i=0; i<K; i++) bfs(li.get(i)[0],li.get(i)[1]);
	}
	
	static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r,c});
		vis[r][c]=true;
		int tmp=1;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int dir=0; dir<4; dir++) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=N||nc<0||nc>=M) continue;
				if(vis[nr][nc]||arr[nr][nc]==0) continue;
				vis[nr][nc]=true;
				q.offer(new int[] {nr,nc});
				tmp++;
			}
		}
		ans = Math.max(ans, tmp);
	}
}