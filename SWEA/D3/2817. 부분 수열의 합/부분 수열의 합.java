import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,K,ans;
	static int[] A,sel;
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] sz = br.readLine().split(" ");
			N = Integer.parseInt(sz[0]);
			K = Integer.parseInt(sz[1]);
			A = new int[N];
			sel = new int[N];
			String[] arr = br.readLine().split(" ");
			for(int i=0; i<N; i++) A[i]=Integer.parseInt(arr[i]);
			powerset(0);
			System.out.println("#"+test_case+" "+ans);
			ans=0;
		}
	}
	
	static void powerset(int cnt) {
		if(cnt==N) {
			calcSum(sel);
			return;
		}
		sel[cnt]=A[cnt];
		powerset(cnt+1);
		sel[cnt]=0;
		powerset(cnt+1);
	}
	
	static void calcSum(int[] sel) {
		int tmp=0;
		for(int s : sel) tmp+=s;
		if(tmp==K) ans++;
	}
}