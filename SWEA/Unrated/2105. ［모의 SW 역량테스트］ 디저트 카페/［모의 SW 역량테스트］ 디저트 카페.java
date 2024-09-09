import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N,ans;
	static int[][] cafe;
	static boolean[] vis;
	static int[] dr = {1,1,-1,-1};
	static int[] dc = {1,-1,-1,1};
	
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			cafe = new int[N][N];
			vis = new boolean[101];
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) cafe[r][c]=Integer.parseInt(st.nextToken());
			}
			ans=-1;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) dfs(r,c,r,c,0,0);
			}
			sb.append("#").append(test_case).append(" ").append(ans);
			System.out.println(sb);
			sb.setLength(0);
		}
	}
	
	static void dfs(int startR, int startC, int curR, int curC, int dir, int cnt) {
		if(dir==4) return;
		for(int d=dir; d<4; d++) {
			int nr = curR+dr[d];
			int nc = curC+dc[d];
			if(nr<0||nr>=N||nc<0||nc>=N||vis[cafe[nr][nc]]) continue;
			if(nr==startR && nc==startC && cnt>=3) {
				ans = Math.max(ans, cnt+1);
				continue;
			}
			vis[cafe[nr][nc]]=true;
			dfs(startR,startC,nr,nc,d,cnt+1);
			vis[cafe[nr][nc]]=false;
		}
	}
}