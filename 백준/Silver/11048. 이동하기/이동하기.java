import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int[][] maze,dp;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) maze[r][c] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N][M];
		dp[0][0]=maze[0][0];
		solve();
		System.out.println(dp[N-1][M-1]);
	}
	
	static void solve() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				int curR=r;
				int curC=c;
				List<int[]> tmp = new ArrayList<>();
				if(curR-1>=0 && curR-1<N) {
					if(curC-1>=0 && curC-1<M) {
						tmp.add(new int[] {curR-1,curC-1});
						tmp.add(new int[] {curR-1,curC});
						tmp.add(new int[] {curR,curC-1});
					}
					else tmp.add(new int[] {curR-1,curC});
				}
				else {
					if(curC-1>=0 && curC-1<M) tmp.add(new int[] {curR,curC-1});
				}
				int tmpMax=0;
				for(int[] e : tmp) {
					if(dp[e[0]][e[1]]>tmpMax) tmpMax=dp[e[0]][e[1]];
				}
				dp[curR][curC]=maze[curR][curC]+tmpMax;
			}
		}
	}
}