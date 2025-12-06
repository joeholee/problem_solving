import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static char[] A,B;
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		A = br.readLine().toCharArray();
		B = br.readLine().toCharArray();
		dp = new int[A.length+1][B.length+1];
		for(int i=1; i<=A.length; i++) {
			for(int j=1; j<=B.length; j++) {
				if(A[i-1]==B[j-1]) dp[i][j] = dp[i-1][j-1]+1;
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		sb.append(dp[A.length][B.length]+"").append('\n');
		print(A.length,B.length);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void print(int i, int j) {
		if(i==0||j==0) return;
		if(A[i-1]==B[j-1]) {
			print(i-1,j-1);
			sb.append(A[i-1]);
		} else {
			if(dp[i-1][j]>dp[i][j-1]) print(i-1,j);
			else print(i,j-1);
		}
	}
}