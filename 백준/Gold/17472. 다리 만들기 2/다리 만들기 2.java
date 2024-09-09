import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
import java.io.IOException;

class Edge implements Comparable<Edge> {
	int from,to,weight;
	
	Edge(int from, int to, int weight) {
		this.from=from;
		this.to=to;
		this.weight=weight;
	}
	
	@Override
	public int compareTo(Edge o) {
		return Integer.compare(weight,o.weight);
	}
}

public class Main {
	static int N,M,island,ans;
	static int[][] map;
	static boolean[][] vis;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static List<Edge> edgeList;
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sz = br.readLine().split(" ");
		N = Integer.parseInt(sz[0]);
		M = Integer.parseInt(sz[1]);
		map = new int[N][M];
		vis = new boolean[N][M];
		
		for(int r=0; r<N; r++) {
			String[] row = br.readLine().split(" ");
			for(int c=0; c<M; c++) map[r][c]=Integer.parseInt(row[c]);
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c]==1 && !vis[r][c]) {
					island++;
					bfs(r,c,island);
				}
			}
		}
		
		edgeList = new ArrayList<>();
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c]>0) bridge(r,c);
			}
		}
		
		p = new int[island+1];
		for(int i=1; i<=island; i++) p[i]=i;
		Collections.sort(edgeList);
		int edge=0;
		for(Edge e : edgeList) {
			if(find(e.from)!=find(e.to)) {				
				union(e.from,e.to);
				ans+=e.weight;
				edge++;
			}
			if(edge==island-1) break;
		}
		System.out.println(edge==island-1 ? ans :-1);
	}
	
	static void bfs(int r, int c, int island) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c});
		vis[r][c]=true;
		map[r][c]=island;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int dir=0; dir<4; dir++) {
				int nr = cur[0]+dr[dir];
				int nc = cur[1]+dc[dir];
				if(nr<0||nr>=N||nc<0||nc>=M||vis[nr][nc]||map[nr][nc]==0) continue;
				vis[nr][nc]=true;
				map[nr][nc]=island;
				q.add(new int[] {nr,nc});
			}
		}
	}
	
	static void bridge(int r, int c) {
		for(int dir=0; dir<4; dir++) {
			int nr=r;
			int nc=c;
			int len=0;
			
			while(true) {
				nr+=dr[dir];
				nc+=dc[dir];
				if(nr<0||nr>=N||nc<0||nc>=M||map[nr][nc]==map[r][c]) break;
				if(map[nr][nc]==0) len++;
				else {
					if(len>=2) edgeList.add(new Edge(map[r][c],map[nr][nc],len));
					break;
				}
			}
		}
	}
	
	static int find(int x) {
		if(x!=p[x]) p[x] = find(p[x]);
		return p[x];
 	}
	
	static void union(int a, int b) {
		p[find(b)]=find(a);
	}
}