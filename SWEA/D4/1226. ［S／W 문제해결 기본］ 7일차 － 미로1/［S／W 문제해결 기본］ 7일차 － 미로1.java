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
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[] cur,end;
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String args[]) throws Exception
	{
		for(int t = 1; t <= 10; t++)
		{
			int tc = Integer.parseInt(br.readLine());
			for(int r=0; r<16; r++) {
				char[] row = br.readLine().toCharArray();
				for(int c=0; c<16; c++) {
					maze[r][c]=row[c];
					if(maze[r][c]=='3') end = new int[] {r,c};
				}
			}
			bfs();
			sb.append("#").append(tc).append(" ").append(vis[end[0]][end[1]] ? 1 : 0).append("\n");
			for(boolean[] row : vis) Arrays.fill(row, false);;
			q.clear();
		}
		System.out.println(sb);
	}
	
	static void bfs() {
		vis[1][1]=true;
		q.add(new int[] {1,1});
		while(!q.isEmpty()) {
			cur = q.poll();
			for(int dir=0; dir<4; dir++) {
				int nr=cur[0]+dr[dir];
				int nc=cur[1]+dc[dir];
				if(nr<0||nr>=16||nc<0||nc>=16) continue;
				if(vis[nr][nc]||maze[nr][nc]=='1') continue;
				vis[nr][nc]=true;
				if(nr==end[0]&&nc==end[1]) return;
				q.add(new int[] {nr,nc});
			}
		}
	}
}