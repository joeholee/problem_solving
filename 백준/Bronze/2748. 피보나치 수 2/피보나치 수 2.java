import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static long[] dp;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		dp = new long[n+1];
		dp[0]=0;
		dp[1]=1;
		System.out.println(fib(n));
	}
	
	static long fib(int n) {
		if(n>=2) {
			for(int i=2; i<=n; i++) dp[i]=dp[i-2]+dp[i-1];
		}
		return dp[n];
	}
}