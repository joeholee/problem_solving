import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,B,ans;
	static int[] H;
	
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			ans = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			H = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) H[i]=Integer.parseInt(st.nextToken());
			subset(0,0);
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	static void subset(int sum, int idx) {
		if(sum>=B) {
			ans = Math.min(ans, sum-B);
			return;
		}
		if(idx==N) return;
		subset(sum+H[idx],idx+1);
		subset(sum,idx+1);
	}
}