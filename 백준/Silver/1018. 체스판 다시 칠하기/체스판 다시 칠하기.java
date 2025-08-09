import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int ans = Integer.MAX_VALUE;
	static char[][] board;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for(int r=0; r<N; r++) {
			String line = br.readLine();
			for(int c=0; c<M; c++) board[r][c] = line.charAt(c);
		}
		for(int r=0; r<N-7; r++) {
			for(int c=0; c<M-7; c++) solve(r,c);
		}
		System.out.println(ans);
	}
	
	static void solve(int r, int c) {
		int tmp1=0;
		int tmp2=0;
		char start = board[r][c];
		char start2 = (start == 'W') ? 'B' : 'W';
		for(int i=r; i<r+8; i++) {
			for(int j=c; j<c+8; j++) {
				if((i+j)%2==0) {
					if(board[i][j]!=start) tmp1++;
					if(board[i][j]!=start2) tmp2++;
				} else {
					if(board[i][j]==start) tmp1++;
					if(board[i][j]==start2) tmp2++;
				}
			}
		}
		ans = Math.min(ans, Math.min(tmp1, tmp2));
	}
	
}