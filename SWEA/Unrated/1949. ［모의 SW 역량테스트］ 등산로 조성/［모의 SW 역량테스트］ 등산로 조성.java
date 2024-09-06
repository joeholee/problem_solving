import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	static int N,K,peak,ans;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] map;
	static boolean[][] vis;
	
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] sz = br.readLine().split(" ");
			N = Integer.parseInt(sz[0]);
			K = Integer.parseInt(sz[1]);
			map = new int[N][N];
			vis = new boolean[N][N];
			for(int r=0; r<N; r++) {
				String[] row = br.readLine().split(" ");
				for(int c=0; c<N; c++) {
					map[r][c]=Integer.parseInt(row[c]);
					if(map[r][c]>peak) peak=map[r][c];
				}
			}
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c]==peak) findPath(r,c,peak,1,true);
				}
			}
			sb.append("#").append(test_case).append(" ").append(ans);
			System.out.println(sb);
			sb.setLength(0);
			ans=0;
			peak=0;
		} // tc
	} // main
	
	static void findPath(int r,int c,int curH,int dist,boolean canCarve) {
		if(dist>ans) ans=dist;
		vis[r][c]=true;
		for(int dir=0; dir<4; dir++) {
			int nr = r+dr[dir];
			int nc = c+dc[dir];
			if(nr<0||nr>=N||nc<0||nc>=N||vis[nr][nc]) continue;
			if(curH>map[nr][nc]) findPath(nr,nc,map[nr][nc],dist+1,canCarve);
			else if(canCarve && curH+K>map[nr][nc]) findPath(nr,nc,curH-1,dist+1,false);
		}
		vis[r][c]=false;
	}
} 