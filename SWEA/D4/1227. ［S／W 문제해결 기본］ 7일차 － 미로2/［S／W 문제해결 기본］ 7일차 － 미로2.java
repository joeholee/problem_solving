import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int T,ans;
	static int[] start,end,cur;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] maze;
	static boolean[][] vis;
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String args[]) throws Exception
	{
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			T = Integer.parseInt(br.readLine());
			maze = new int[100][100];
			vis = new boolean[100][100];
			for(int r=0; r<100; r++) {
				String row = br.readLine();
				for(int c=0; c<100; c++) {
					maze[r][c]=row.charAt(c)-'0';
					if(maze[r][c]==2) start = new int[] {r,c};
					if(maze[r][c]==3) end = new int[] {r,c};
				}
			}
			for(boolean[] row : vis) Arrays.fill(row, false);
			bfs();
			ans = vis[end[0]][end[1]] ? 1 : 0;
			sb.append("#").append(T).append(" ").append(ans);
			System.out.println(sb);
			sb.setLength(0);
			
		} // tc
	} // main
	
	static void bfs() {
		vis[start[0]][start[1]]=true;
		q.add(start);
		while(!q.isEmpty()) {
			cur = q.poll();
			for(int dir=0; dir<4; dir++) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=100||nc<0||nc>=100) continue;
				if(maze[nr][nc]==1) continue;
				if(vis[nr][nc]) continue;
				vis[nr][nc]=true;
				q.add(new int[] {nr,nc});
			}
		}
	}
} 