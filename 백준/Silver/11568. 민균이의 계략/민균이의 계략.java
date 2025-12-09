import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,ans;
	static int[] arr,dp;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		dp = new int[N];
		Arrays.fill(dp, 1);
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(arr[j]<arr[i]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
			ans = Math.max(ans, dp[i]);
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}