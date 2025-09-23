import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,T;
	static int[] K,S;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		K = new int[N+1];
		S = new int[T+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			K[i] = Integer.parseInt(st.nextToken());
			S[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N+1][T+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=T; j++) {
				if(K[i]>j) dp[i][j] = dp[i-1][j];
				else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-K[i]]+S[i]);
			}
		}
		bw.write(dp[N][T]+"");
		bw.close();
		br.close();
	}
}