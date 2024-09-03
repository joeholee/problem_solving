import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static int N,M,r,c,d,ans;
	static int[][] board;
	static int[] dr = {-1,0,1,0}; // d에 따른 방향
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] sz = br.readLine().split(" ");
		N = Integer.parseInt(sz[0]);
		M = Integer.parseInt(sz[1]);
		board = new int[N][M];
		String[] info = br.readLine().split(" ");
		r = Integer.parseInt(info[0]);
		c = Integer.parseInt(info[1]);
		d = Integer.parseInt(info[2]);
		for(int r=0; r<N; r++) {
			String[] row = br.readLine().split(" ");
			for(int c=0; c<M; c++) board[r][c]=Integer.parseInt(row[c]);
		}
		// 최초 상황에서 무조건 1번 청소 가능
		ans++;
		solve(r,c,d);
		System.out.println(ans);
	}
	
	static void solve(int r, int c, int dir) {
		board[r][c]=-1;
		for(int i=0; i<4; i++) {
			dir = (dir+3)%4;
			int nr = r+dr[dir];
			int nc = c+dc[dir];
			if(nr>=0 && nr<N && nc>=0 && nc<M && board[nr][nc]==0) {
				ans++;
				solve(nr,nc,dir);
				return;
			}
		}
		int back = (dir+2)%4;
		int br = r+dr[back];
		int bc = c+dc[back];
		if(br>=0 && br<N && bc>=0 && bc<M && board[br][bc]!=1) solve(br,bc,dir);
	}
}