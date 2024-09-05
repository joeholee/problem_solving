import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[][] map;
	static int[][] dist;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[] cur;
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String args[]) throws Exception
	{
		int C;
		C = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= C; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dist = new int[N][N];
			for(int r=0; r<N; r++) {
				String row = br.readLine();
				for(int c=0; c<N; c++) map[r][c] = row.charAt(c)-'0';
			}
			for(int[] d : dist) Arrays.fill(d,Integer.MAX_VALUE);
			bfs();
			System.out.println("#"+test_case+" "+dist[N-1][N-1]);
		}
	}
	
	static void bfs() {
		q.add(new int[] {0,0,0});
		while(!q.isEmpty()) {
			cur = q.poll();
			for(int dir=0; dir<4; dir++) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=N||nc<0||nc>=N) continue;
				int nd = cur[2]+map[nr][nc];
				if(dist[nr][nc]>nd) {
					dist[nr][nc]=nd;
					q.add(new int[] {nr,nc,nd});
				}
			}
		}
	}
}