import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static int w,h,ans;
	static int[] cur;
	static int[][] map;
	static boolean[][] vis;
	static int[] dr = {-1,-1,-1,0,1,1,1,0};
	static int[] dc = {-1,0,1,1,1,0,-1,-1};
 	static Queue<int[]> q = new LinkedList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		while(true) {
			String[] size = br.readLine().split(" ");
			w = Integer.parseInt(size[0]);
			h = Integer.parseInt(size[1]);
			if(w==0 && h==0) return;
			map = new int[h][w];
			vis = new boolean[h][w];
			for(int r=0; r<h; r++) {
				String[] row = br.readLine().split(" ");
				for(int c=0; c<w; c++) map[r][c]=Integer.parseInt(row[c]);
			}
			for(int r=0; r<h; r++) {
				for(int c=0; c<w; c++) {
					if(!vis[r][c]&&map[r][c]==1) bfs(r,c);
				}
			}
			System.out.println(ans);
			ans=0;
		}
	}
	static void bfs(int r, int c) {
		q.add(new int[] {r,c});
		vis[r][c]=true;
		while(!q.isEmpty()) {
			cur = q.poll();
			for(int dir=0; dir<8; dir++) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=h||nc<0||nc>=w||vis[nr][nc]) continue;
				if(map[nr][nc]==0) continue;
				q.add(new int[] {nr,nc});
				vis[nr][nc]=true;
			}
		}
		ans++;
	}
}