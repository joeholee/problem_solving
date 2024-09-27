import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
//		System.out.println(Arrays.deepToString(map));
		int max = 0;
		for(int depth=0; depth<=100; depth++) {
			int cnt = 0;
			visited = new boolean[N][N];
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c] > depth && !visited[r][c]) {
						visited[r][c] = true;
						dfs(r,c,depth);
						cnt++; // 새로운 그래프를 찾았으므로.
						
					}
				}
			}
			if(cnt > max) max = cnt;
		}
		System.out.println(max);
	}

	private static void dfs(int r, int c, int depth) {
		for(int d=0; d<4; d++) {
			int nr = r+ dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nr >=N || nc <0 || nc >= N) continue;
			if(map[nr][nc]>depth && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, depth);
			}
		}
	}
}