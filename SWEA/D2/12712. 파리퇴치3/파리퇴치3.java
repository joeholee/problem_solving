import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,M,ans;
	static int[][] fly;
	static int[] dr = {-1,0,1,0,-1,-1,1,1};
	static int[] dc = {0,1,0,-1,-1,1,1,-1};
	public static void main(String args[]) throws Exception
	{
		int T;
		T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] sz = br.readLine().split(" ");
			N = Integer.parseInt(sz[0]);
			M = Integer.parseInt(sz[1]);
			fly = new int[N][N];
			for(int r=0; r<N; r++) {
				String[] input = br.readLine().split(" ");
				for(int c=0; c<N; c++) fly[r][c]=Integer.parseInt(input[c]);
			}
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					int tmp=fly[r][c];
					for(int dir=0; dir<4; dir++) {
						for(int k=1; k<M; k++) {
							int nr = r+k*dr[dir];
							int nc = c+k*dc[dir];
							if(nr<0||nr>=N||nc<0||nc>=N) continue;
							tmp+=fly[nr][nc];
						}
					}
					ans = Math.max(ans,tmp);
					tmp = fly[r][c];
					for(int dir=4; dir<8; dir++) {
						for(int k=1; k<M; k++) {
							int nr = r+k*dr[dir];
							int nc = c+k*dc[dir];
							if(nr<0||nr>=N||nc<0||nc>=N) continue;
							tmp+=fly[nr][nc];
						}
					}
					ans = Math.max(ans,tmp);
				}
			}
			System.out.println("#"+test_case+" "+ans);
			ans=0;
		}
	}
}