import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,k;
	static int[] val,dp;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		val = new int[n+1];
		for(int i=1; i<=n; i++) val[i]=Integer.parseInt(br.readLine());
		dp = new int[k+1];
		Arrays.fill(dp, INF);
		dp[0]=0;
		for(int v : val) {
			for(int i=v; i<=k; i++) {
				if(dp[i-v] != INF) dp[i]=Math.min(dp[i], dp[i-v]+1);
			}
		}
		System.out.println(dp[k]==INF? -1 : dp[k]);
	}
}