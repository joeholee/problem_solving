import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,ans;
	static boolean[] col = new boolean[21];
	static boolean[] diag1 = new boolean[21];
	static boolean[] diag2 = new boolean[21];
	public static void main(String args[]) throws Exception
	{
		int T;
		T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = Integer.parseInt(br.readLine());
            solve(0);
            System.out.println("#"+test_case+" "+ans);
            ans=0;
		}
	}
	
	static void solve(int idx) {
		if(idx==N) {
			ans++;
			return;
		}
		for(int i=0; i<N; i++) {
			if(col[i]==true || diag1[i+idx]==true || diag2[idx-i+N-1]==true) continue;
			col[i]=true;
			diag1[i+idx]=true;
			diag2[idx-i+N-1]=true;
			solve(idx+1);
			col[i]=false;
			diag1[i+idx]=false;
			diag2[idx-i+N-1]=false;
		}
	}
}