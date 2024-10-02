import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		for(int i=1; i<=N; i++) dp[i]=i;
		for(int i=1; i*i<=N; i++) {
			int square = i*i;
			for(int j=square; j<=N; j++) {
				dp[j]=Math.min(dp[j], dp[j-square]+1);
			}
		}
		System.out.println(dp[N]);
	}
}