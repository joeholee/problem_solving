import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int[] A,dp;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		A = new int[N];
		dp = new int[N];
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0]=0;
		for(int i=0; i<N; i++) {
			if(dp[i]==Integer.MAX_VALUE) continue;
			int val = A[i];
			for(int j=i+1; j<=i+val; j++) {
				if(j<N) dp[j] = Math.min(dp[j], dp[i]+1);
			}
		}
		bw.write((dp[N-1]==Integer.MAX_VALUE ? -1 : dp[N-1])+"");
		bw.close();
		br.close();
	}
}