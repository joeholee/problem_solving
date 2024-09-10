import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T,N,M;
	static int[][] dp = new int[30][30];
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int i=0; i<30; i++) {
			dp[i][0]=dp[i][i]=1;
			for(int j=1; j<i; j++) {
				dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
			}
		}
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			sb.append(dp[M][N]).append("\n");
		}
		System.out.println(sb);
	}
}