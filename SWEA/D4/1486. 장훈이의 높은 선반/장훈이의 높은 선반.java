import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static int N,B,ans;
	static int[] H;
	static boolean[] vis;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String[] sz = br.readLine().split(" ");
            N = Integer.parseInt(sz[0]);
            B = Integer.parseInt(sz[1]);
            H = new int[N];
            vis = new boolean[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) H[i]=Integer.parseInt(st.nextToken());
            ans = Integer.MAX_VALUE;
            subset(0,0);
            System.out.println("#"+test_case+" "+(ans-B));
		}
	}
	
	static void subset(int cnt, int sum) {
		if(sum>=B) {
			ans = Math.min(ans,sum);
			return;
		}
		if(cnt==N) return;
		subset(cnt+1,sum+H[cnt]);
		subset(cnt+1,sum);
	}
}