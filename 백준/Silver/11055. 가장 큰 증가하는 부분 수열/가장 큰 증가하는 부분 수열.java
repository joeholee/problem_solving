import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,ans=Integer.MIN_VALUE;
	static int[] A,dp;
 	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		A = new int[N];
		dp = new int[N];
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			dp[i] = A[i];
			for(int j=0; j<i; j++) {
				if(A[i]>A[j]) dp[i] = Math.max(dp[i], dp[j]+A[i]);
			}
		}
		for(int i : dp) ans = Math.max(ans, i);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}