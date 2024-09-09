import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] dr = {-1,1,0,0}; // 상하좌우
	static int[] dc = {0,0,-1,1};
	static int N,M,R,C,L,ans;
	static int[][] tunnel;
	static boolean[][] vis;
	static int[][] link = {
			{},
			{0,1,2,3},
			{0,1},
			{2,3},
			{0,3},
			{1,3},
			{1,2},
			{0,2}
	};
	static int[] cur;
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			tunnel = new int[N][M];
			vis = new boolean[N][M];
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<M; c++) tunnel[r][c]=Integer.parseInt(st.nextToken());
			}
			bfs();
			sb.append("#").append(test_case).append(" ").append(ans);
			System.out.println(sb);
			sb.setLength(0);
			ans=0;
		}
	}
	
	static void bfs() {
		q.add(new int[] {R,C,1});
		vis[R][C]=true;
		ans=1;
		while(!q.isEmpty()) {
			cur = q.poll();
			if(cur[2]>=L) continue;
			for(int dir : link[tunnel[cur[0]][cur[1]]]) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=N||nc<0||nc>=M) continue;
				if(vis[nr][nc]) continue;
				if(tunnel[nr][nc]==0) continue;
				if(check(dir,tunnel[nr][nc])) {
					vis[nr][nc]=true;
					q.add(new int[] {nr,nc,cur[2]+1});
					ans++;
				}
			}
		}
	}
	
	static boolean check(int dir, int nxt) {
		if(dir==0 && (nxt==1||nxt==2||nxt==5||nxt==6)) return true;
		if(dir==1 && (nxt==1||nxt==2||nxt==4||nxt==7)) return true;
		if(dir==2 && (nxt==1||nxt==3||nxt==4||nxt==5)) return true;
		if(dir==3 && (nxt==1||nxt==3||nxt==6||nxt==7)) return true;
		return false;
	}
}