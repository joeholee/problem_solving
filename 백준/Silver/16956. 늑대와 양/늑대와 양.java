import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int R,C;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static char[][] farm;
	static Queue<int[]> q = new LinkedList<>();
	static boolean able = true;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		farm = new char[R][C];
		for(int r=0; r<R; r++) {
			char[] status = br.readLine().toCharArray();
			for(int c=0; c<C; c++) {
				farm[r][c] = status[c];
				if(farm[r][c]=='W') q.add(new int[]{r,c});
			}
		}
		bfs();
		if(!able) System.out.println("0");
		else {
            System.out.println("1");
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) System.out.print(farm[r][c]);
				System.out.println();
			}
		}
	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			for(int dir=0; dir<4; dir++) {
				int nr = r+dr[dir];
				int nc = c+dc[dir];
				if(nr>=0 && nr<R && nc>=0 && nc<C) {
					if(farm[nr][nc]=='.') farm[nr][nc]='D';
					if(farm[nr][nc]=='S') {
						able=false;
						return;
					}
				}
			}
		}
	}
}