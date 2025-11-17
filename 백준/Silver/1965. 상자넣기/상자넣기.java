import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n,ans=Integer.MIN_VALUE;
	static int[] arr,dp;
 	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
		dp = new int[n];
		Arrays.fill(dp, 1);
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i]>arr[j]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}
		for(int i : dp) ans = Math.max(ans, i);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}