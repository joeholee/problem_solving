import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int[] dp = new int[50001];
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		for(int i=1; i<=n; i++) {
			dp[i] = i;
			for(int j=1; j*j<=i; j++) dp[i] = Math.min(dp[i], dp[i-j*j]+1);
		}
		bw.write(dp[n]+"");
		bw.close();
		br.close();
	}
}