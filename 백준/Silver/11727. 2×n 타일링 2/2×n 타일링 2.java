import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		dp[1]=1;
		if(n>=2) dp[2]=3;
		if(n>=3) {
			for(int i=3; i<=n; i++) dp[i] = (dp[i-1]+2*dp[i-2])%10007;
		}
		bw.write(dp[n]+"");
		bw.close();
		br.close();
	}
}