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
		dp();
		System.out.println(dp[N]);
	}
	
	static void dp() {
		for(int i=2; i<=N; i++) {
			dp[i]=dp[i-1]+1;
			if(i%2==0) dp[i]=Math.min(dp[i], dp[i/2]+1);
			if(i%3==0) dp[i]=Math.min(dp[i], dp[i/3]+1);
		}
	}
}