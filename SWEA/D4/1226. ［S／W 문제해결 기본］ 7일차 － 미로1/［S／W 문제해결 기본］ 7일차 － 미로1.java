import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static char[][] maze = new char[16][16];
	static boolean[][] vis = new boolean[16][16];
	static int[] cur;
	static int[] fin = new int[2];
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String args[]) throws Exception
	{
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int t = Integer.parseInt(br.readLine());
			for(boolean[] b : vis) Arrays.fill(b, false);
			for(int r=0; r<16; r++) {
				char[] row = br.readLine().toCharArray();
				for(int c=0; c<16; c++) {
					maze[r][c]=row[c];
					if(maze[r][c]=='2') {
						q.add(new int[] {r,c});
						vis[r][c]=true;
					}
					if(maze[r][c]=='3') fin = new int[] {r,c};
				}
			}
			bfs();
			sb.append("#").append(t).append(" ");
			sb.append(vis[fin[0]][fin[1]] ? 1 : 0).append("\n");
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			cur = q.poll();
			for(int dir=0; dir<4; dir++) {
				int nr=cur[0]+dr[dir];
				int nc=cur[1]+dc[dir];
				if(nr<0||nr>=16||nc<0||nc>=16) continue;
				if(vis[nr][nc]||maze[nr][nc]=='1') continue;
				vis[nr][nc]=true;
				q.add(new int[] {nr,nc});
			}
		}
	}
}