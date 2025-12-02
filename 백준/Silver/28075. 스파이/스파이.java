import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M,ans;
	static int[][] arr = new int[2][3];
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<2; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		solve(0,0,-1);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void solve(int cnt, int sum, int idx) {
		if(cnt==N) {
			if(sum>=M) ans++;
			return;
		}
		for(int i=0; i<2; i++) {
			for(int j=0; j<3; j++) {
				if(j==idx) solve(cnt+1,sum+(arr[i][j])/2,j);
				else solve(cnt+1,sum+arr[i][j],j);
			}
		}
	}
}