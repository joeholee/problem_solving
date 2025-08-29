import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int[][] arr;
	static int[][][] dp;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new int[N][N][3];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) arr[r][c] = Integer.parseInt(st.nextToken());
		}
		dp[0][1][0]=1;
		for(int r=0; r<N; r++) {
			for(int c=2; c<N; c++) {
				if(c-1>=0 && arr[r][c]==0) dp[r][c][0]=dp[r][c-1][0]+dp[r][c-1][2];
				if(r-1>=0 && arr[r][c]==0) dp[r][c][1]=dp[r-1][c][1]+dp[r-1][c][2];
				if(r-1>=0 && c-1>=0 && arr[r][c]==0 && arr[r-1][c]==0 && arr[r][c-1]==0) dp[r][c][2]=dp[r-1][c-1][0]+dp[r-1][c-1][1]+dp[r-1][c-1][2];
			}
		}
		bw.write(dp[N-1][N-1][0]+dp[N-1][N-1][1]+dp[N-1][N-1][2]+"");
		bw.close();
		br.close();
	}
}