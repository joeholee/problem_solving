import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class Solution
{
	static class Point {
		int x, y, dist, dir;
		
		Point(int x, int y, int dist, int dir) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.dir = dir;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int x1,y1,x2,y2,ans;
	static int[] dx = {0,0,1,-1}; //  세로 가로
	static int[] dy = {1,-1,0,0};
	static Point cur;
	
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken())+100;
			y1 = Integer.parseInt(st.nextToken())+100;
			x2 = Integer.parseInt(st.nextToken())+100;
			y2 = Integer.parseInt(st.nextToken())+100;
			solve();
			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	static void solve() {
		Queue<Point> q = new LinkedList<>();
		boolean vis[][][] = new boolean[201][201][2];
		q.add(new Point(x1,y1,0,0));
		vis[y1][x1][0]=true;
		q.add(new Point(x1,y1,0,1));
		vis[y1][x1][1]=true;
		while(!q.isEmpty()) {
			cur = q.poll();
			if(cur.x==x2 && cur.y==y2) {
				ans=cur.dist;
				return;
			}
			if(cur.dir==0) {
				for(int dir=0; dir<2; dir++) {
					int nx = cur.x+dx[dir];
					int ny = cur.y+dy[dir];
					if(nx<0||nx>=201||ny<0||ny>=201) continue;
					if(vis[ny][nx][1]) continue;
					q.add(new Point(nx,ny,cur.dist+1,1));
					vis[ny][nx][1]=true;
				}
			}
			else {
				for(int dir=2; dir<4; dir++) {
					int nx = cur.x+dx[dir];
					int ny = cur.y+dy[dir];
					if(nx<0||nx>=201||ny<0||ny>=201) continue;
					if(vis[ny][nx][0]) continue;
					q.add(new Point(nx,ny,cur.dist+1,0));
					vis[ny][nx][0]=true;
				}
			}
		}
	}
}