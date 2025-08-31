import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int[] P,dp;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		P = new int[N+1];
		dp = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) P[i] = Integer.parseInt(st.nextToken());
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j]+P[j]);
			}
		}
		bw.write(dp[N]+"");
		bw.close();
		br.close();
	}
}