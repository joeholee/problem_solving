import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,k;
	static int[] coins,dp;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		coins = new int[n];
		for(int i=0; i<n; i++) coins[i]=Integer.parseInt(br.readLine());
		dp = new int[k+1];
		dp[0]=1; // 0원 만드는 방법은 1가지
		
		for(int i=0; i<n; i++) {
			for(int j=coins[i]; j<=k; j++) {
				dp[j]+=dp[j-coins[i]];
			}
 		}
		System.out.println(dp[k]);
	}
}