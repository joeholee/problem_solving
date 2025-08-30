import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T,N,M;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			int[] coins = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) coins[i] = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(br.readLine());
			int[] dp = new int[M+1];
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					if(j-coins[i]>0) dp[j]+=dp[j-coins[i]];
					else if(j-coins[i]==0) dp[j]++;
				}
			}
			sb.append(dp[M]).append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}