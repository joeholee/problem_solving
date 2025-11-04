import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		dp[1] = -1;
		if(n>=2) dp[2] = 1;
		if(n>=3) dp[3] = -1;
		if(n>=4) dp[4] = 2;
		if(n>=5) dp[5] = 1;
		if(n>=6) {
			for(int i=6; i<=n; i++) {
				int x = dp[i-5];
				int y = dp[i-2];
				if(x==-1) dp[i] = y+1;
				else if(y==-1) dp[i] = x+1;
				else dp[i] = Math.min(x, y)+1;
			}
		}
		bw.write(dp[n]+"");
		bw.close();
		br.close();
	}
}