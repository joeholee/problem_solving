import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution
{
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int D,W,K,ans;
	static int[][] film;
	static int[] A,B;
	
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] sz = br.readLine().split(" ");
			D = Integer.parseInt(sz[0]);
			W = Integer.parseInt(sz[1]);
			K = Integer.parseInt(sz[2]);
			film = new int[D][W];
			A = new int[W];
			B = new int[W];
			Arrays.fill(B,1);
			for(int r=0; r<D; r++) {
				String[] cell = br.readLine().split(" ");
				for(int c=0; c<W; c++) film[r][c]=Integer.parseInt(cell[c]);
			}
			ans=K;
			inject(0,0);
			sb.append("#").append(test_case).append(" ").append(ans);
			System.out.println(sb);
			sb.setLength(0);
		} // tc
	} // main
	
	static void inject(int idx, int cnt) {
		if(canPass()) {
			ans = Math.min(ans, cnt);
			return;
		}
		if(ans<cnt) return;
		if(idx==D) return;
		inject(idx+1,cnt);
		int[] tmp = film[idx];
		film[idx]=A;
		inject(idx+1,cnt+1);
		film[idx]=B;
		inject(idx+1,cnt+1);
		film[idx]=tmp;
	}
	
	static boolean canPass() {
		for(int c=0; c<W; c++) {
			boolean flag=false;
			int cnt=1;
			for(int r=1; r<D; r++) {
				if(film[r][c]==film[r-1][c]) cnt++;
				else cnt=1;
				if(cnt>=K) {
					flag=true;
					break;
				}
			}
			if(!flag) return false;
		}
		return true;
	}
	
} 