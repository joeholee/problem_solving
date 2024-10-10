import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,K;
	static int[] I,T;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[K+1][N+1];
		I = new int[K+1];
		T = new int[K+1];
		for(int i=1; i<=K; i++) {
			st = new StringTokenizer(br.readLine());
			I[i] = Integer.parseInt(st.nextToken());
			T[i] = Integer.parseInt(st.nextToken());
		}
		solve();
		System.out.println(dp[K][N]);
	}
	
	static void solve() {
		for(int i=1; i<=K; i++) {
			for(int j=1; j<=N; j++) {
				if(T[i]>j) dp[i][j]=dp[i-1][j];
				else dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-T[i]]+I[i]);
			}
		}
	}
}