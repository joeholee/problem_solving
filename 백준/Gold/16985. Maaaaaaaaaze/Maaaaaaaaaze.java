import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int ans = Integer.MAX_VALUE;
	static int[][][] maze = new int[5][5][5];
	static int[] order = new int[5]; // layer
	static int[] rotation = new int[5];
	static boolean[] vis = new boolean[5];
	static final int[] dz = {-1,1,0,0,0,0};
	static final int[] dx = {0,0,-1,1,0,0};
	static final int[] dy = {0,0,0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		for(int z=0; z<5; z++) {
			for(int x=0; x<5; x++) {
				st = new StringTokenizer(br.readLine());
				for(int y=0; y<5; y++) maze[z][x][y] = Integer.parseInt(st.nextToken());
			}
		}
		perm(0);
		ans = (ans==Integer.MAX_VALUE ? -1 : ans);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void perm(int depth) {
		if(depth==5) {
			rotate(0);
			return;
		}
		for(int i=0; i<5; i++) {
			if(!vis[i]) {
				order[depth]=i;
				vis[i]=true;
				perm(depth+1);
				vis[i]=false;
			}
		}
	}
	
	static void rotate(int depth) {
		if(depth==5) {
			bfs();
			return;
		}
		for(int i=0; i<4; i++) {
			rotation[depth]=i;
			rotate(depth+1);
		}
	}
	
	static void bfs() {
		int[][][] tmp = new int[5][5][5];
		for(int z=0; z<5; z++) {
			int d = rotation[z];
			switch(d) {
			case 0:
				for(int x=0; x<5; x++) {
					for(int y=0; y<5; y++) tmp[z][x][y] = maze[order[z]][x][y];
				}
				break;
			case 1:
				for(int x=0; x<5; x++) {
					for(int y=0; y<5; y++) tmp[z][x][y] = maze[order[z]][4-y][x];
				}
				break;
			case 2:
				for(int x=0; x<5; x++) {
					for(int y=0; y<5; y++) tmp[z][x][y] = maze[order[z]][4-x][4-y];
				}
				break;
			case 3:
				for(int x=0; x<5; x++) {
					for(int y=0; y<5; y++) tmp[z][x][y] = maze[order[z]][y][4-x];
				}
				break;
			}
		}
		if(tmp[0][0][0]==0||tmp[4][4][4]==0) return;
		boolean[][][] check = new boolean[5][5][5];
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0,0,0,0});
		check[0][0][0] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int z = cur[0];
			int x = cur[1];
			int y = cur[2];
			int dist = cur[3];
			if(z==4&&x==4&&y==4) {
				ans = Math.min(ans, dist);
				if(ans==12) {
					System.out.println(12);
					System.exit(0);
				}
			}
			if(dist>=ans) return;
			for(int dir=0; dir<6; dir++) {
				int nz = z+dz[dir];
				int nx = x+dx[dir];
				int ny = y+dy[dir];
				if(nz<0||nz>=5||nx<0||nx>=5||ny<0||ny>=5) continue;
				if(check[nz][nx][ny]) continue;
				if(tmp[nz][nx][ny]==0) continue;
				check[nz][nx][ny]=true;
				q.offer(new int[] {nz,nx,ny,dist+1});
			}
		}
	}
}