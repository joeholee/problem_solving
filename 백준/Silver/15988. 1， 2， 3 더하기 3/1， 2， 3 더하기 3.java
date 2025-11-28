import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int n,T;
	static long[] dp;
	
	public static void main(String[] args) throws IOException {
		dp = new long[1_000_001];
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		for(int i=4; i<=1_000_000; i++) dp[i] = (dp[i-3]+dp[i-2]+dp[i-1])%1_000_000_009;
		T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}