import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M;
	static int[] A,m;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N+1];
		m = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) A[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) m[i] = Integer.parseInt(st.nextToken());
		dp = new int[N+1][10001];
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=10000; j++) {
				if(j<m[i]) dp[i][j]=dp[i-1][j];
				else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-m[i]]+A[i]);
			}
		}
		for(int i=0; i<=10000; i++) {
			if(dp[N][i]>=M) {
				bw.write(i+"");
				break;
			}
		}
		bw.close();
		br.close();
	}
}