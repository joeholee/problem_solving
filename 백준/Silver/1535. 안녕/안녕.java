import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int[] W,V;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		W = new int[N+1];
		V = new int[N+1];
		dp = new int[N+1][100];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) W[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) V[i] = Integer.parseInt(st.nextToken());
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=99; j++) {
				if(W[i]>j) dp[i][j] = dp[i-1][j];
				else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]]+V[i]);
			}
		}
		bw.write(dp[N][99]+"");
		bw.close();
		br.close();
	}
}