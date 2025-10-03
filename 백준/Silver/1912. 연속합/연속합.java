import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n;
	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) arr[i] = Integer.parseInt(st.nextToken());
		dp = new int[n+1];
		dp[1] = arr[1];
		int ans = dp[1];
		for(int i=2; i<=n; i++) {
			dp[i] = Math.max(arr[i], dp[i-1]+arr[i]);
			ans = Math.max(ans, dp[i]);
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}