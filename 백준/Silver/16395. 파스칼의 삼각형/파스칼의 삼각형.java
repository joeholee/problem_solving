import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n,k;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dp = new int[n][n];
		dp[0][0]=1;
		for(int i=1; i<n; i++) {
			for(int j=0; j<=i; j++) {
				if(j==0||j==i) dp[i][j]=1;
				else dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
			}
		}
		bw.write(dp[n-1][k-1]+"");
		bw.close();
		br.close();
	}
}