import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N,ans;
	static final int MOD = 1_000_000_000;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1][10];
		// i-digit ends with j
		for(int j=1; j<=9; j++) dp[1][j]=1;
		for(int i=2; i<=N; i++) {
			for(int j=0; j<=9; j++) {
				if(j>0) dp[i][j]+=dp[i-1][j-1];
				if(j<9) dp[i][j]+=dp[i-1][j+1];
				dp[i][j]%=MOD;
			}
		}
		for(int j=0; j<=9; j++) ans = (ans+dp[N][j])%MOD;
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}