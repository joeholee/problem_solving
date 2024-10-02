import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,K;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			dp[i][0]=1;
			dp[i][1]=i;
			dp[i][i]=1;
		}
		for(int i=1; i<=N; i++) {
			for(int j=2; j<=K; j++) {
				dp[i][j]=(dp[i-1][j-1]+dp[i-1][j])%10007;
			}
		}
		System.out.println(dp[N][K]);
	}
}