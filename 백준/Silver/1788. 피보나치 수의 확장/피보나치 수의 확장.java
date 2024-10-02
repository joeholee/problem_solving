import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N,num;
	static int[] dp;                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		num = Math.abs(N);
		dp = new int[num+1];
		if(num>=1) dp[1]=1;
		if(num>=2) {
			for(int i=2; i<=num; i++) dp[i]=(dp[i-2]+dp[i-1])%1000000000;
		}
		if(N>0) sb.append(1).append("\n").append(dp[N]);
		else if(N==0) sb.append(0).append("\n").append(0);
		else {
			if(num%2==0) sb.append(-1).append("\n").append(dp[num]);
			else sb.append(1).append("\n").append(dp[num]);
		}
		System.out.println(sb);
	}
}