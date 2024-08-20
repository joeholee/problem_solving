import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
	static int N,M,w,b,r,ans;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[][] flag;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			flag = new char[N][M];
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				char[] row = st.nextToken().toCharArray();
				for(int c=0; c<M; c++) flag[r][c]=row[c];
			}
			w=0;b=0;r=0;
			ans=Integer.MAX_VALUE;
			for(int i=0; i<N-2; i++) {
				countCol(i,'W');
				b=0;
				for(int j=i+1; j<N-1; j++) {
					countCol(j,'B');
					r=0;
					for(int k=j+1; k<N; k++) {
						countCol(k,'R');
					}
					ans = Math.min(ans,w+b+r);
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void countCol(int row, char col) {
		for(char c : flag[row]) {
			if(c!=col) {
				switch(col) {
					case 'W': 
						w++;
						break;
					case 'B':
						b++;
						break;
					case 'R':
						r++;
						break;
				} 
			}
		}
	}
}