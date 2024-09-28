import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,tmpA,tmpB,diff;
	static boolean[] vis;
	static int[][] S;
	
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++)
		{
			diff=Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			S = new int[N][N];
			vis = new boolean[N];
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) S[r][c]=Integer.parseInt(st.nextToken());
			}
			comb(0,0);
			sb.append("#").append(t).append(" ").append(diff).append("\n");
		}
		System.out.println(sb);
	}
	
	static void comb(int cnt, int idx) {
		if(cnt==N/2) {
			calcDiff();
			return;
		}
		for(int i=idx; i<N; i++) {
			vis[i]=true;
			comb(cnt+1,i+1);
			vis[i]=false;
		}
	}
	
	static void calcDiff() {
		tmpA=tmpB=0;
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(vis[i]&&vis[j]) tmpA+=S[i][j]+S[j][i];
				else if(!vis[i]&&!vis[j]) tmpB+=S[i][j]+S[j][i];
			}
		}
		diff=Math.min(diff,Math.abs(tmpA-tmpB));
	}
}