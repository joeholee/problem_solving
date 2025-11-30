import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T,N,M;
	static int[] arr,dp;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			arr = new int[N];
			for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(br.readLine());
			dp = new int[M+1];
			dp[0]=1;
			for(int i=0; i<N; i++) {
				for(int j=arr[i]; j<=M; j++) dp[j]+=dp[j-arr[i]];
			}
			sb.append(dp[M]).append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}