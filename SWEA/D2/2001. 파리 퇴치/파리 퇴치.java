import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,M,ans;
	static int[][] fly;
	public static void main(String args[]) throws Exception
	{
		int T;
		T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] sz = br.readLine().split(" ");
			N = Integer.parseInt(sz[0]);
			M = Integer.parseInt(sz[1]);
			fly = new int[N][N];
			for(int r=0; r<N; r++) {
				String[] input = br.readLine().split(" ");
				for(int c=0; c<N; c++) fly[r][c] = Integer.parseInt(input[c]);
			}
			for(int r=0; r<N-M+1; r++) {
				for(int c=0; c<N-M+1; c++) {
					int tmp=0;
					for(int dr=0; dr<M; dr++) {
						for(int dc=0; dc<M; dc++) {
							int nr=r+dr;
							int nc=c+dc;
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