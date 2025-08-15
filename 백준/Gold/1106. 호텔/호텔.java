import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int C,N,ans;
	static int[] cost,customer,dp;
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		cost = new int[N];
		customer = new int[N];
		dp = new int[C+101];
		Arrays.fill(dp, INF);
		dp[0]=0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i] = Integer.parseInt(st.nextToken());
			customer[i] = Integer.parseInt(st.nextToken());
			for(int j=customer[i]; j<C+101; j++) {
				dp[j]=Math.min(dp[j], dp[j-customer[i]]+cost[i]);
			}
		}
		
		ans = INF;
		for(int i=C; i<C+101; i++) ans = Math.min(ans, dp[i]);
		
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}