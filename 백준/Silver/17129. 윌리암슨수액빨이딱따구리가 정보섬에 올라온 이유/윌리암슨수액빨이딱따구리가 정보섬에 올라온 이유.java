import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
	static int n,m;
	static char[][] island;
	static int[][] dist;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[] cur;
	static Queue<int[]> q = new LinkedList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		String[] size = br.readLine().split(" ");
		n = Integer.parseInt(size[0]);
		m = Integer.parseInt(size[1]);
		island = new char[n][m];
		dist = new int[n][m];
		for(int[] row : dist) Arrays.fill(row,-1);
		for(int r=0; r<n; r++) {
			char[] row = br.readLine().toCharArray();
			for(int c=0; c<m; c++) {
				island[r][c]=row[c];
				if(island[r][c]=='2') cur = new int[] {r,c};
			}
		}
		bfs();
		System.out.println(sb);
	}
	
	static void bfs() {
		q.add(cur);
		dist[cur[0]][cur[1]]=0;
		while(!q.isEmpty()) {
			cur = q.poll();
			for(int dir=0; dir<4; dir++) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=n||nc<0||nc>=m) continue;
				if(dist[nr][nc]!=-1) continue;
				if(island[nr][nc]=='1') continue;
				if(island[nr][nc]>='3') {
					sb.append("TAK").append("\n").append(dist[cur[0]][cur[1]]+1);
					return;
				}
				dist[nr][nc]=dist[cur[0]][cur[1]]+1;
				q.add(new int[] {nr,nc});
			}
		}
		sb.append("NIE");
	}
}