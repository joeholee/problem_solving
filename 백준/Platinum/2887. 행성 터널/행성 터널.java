import java.io.*;
import java.util.*;

public class Main {
	
	static class Planet {
		int idx,x,y,z;
		
		Planet(int idx, int x, int y, int z) {
			this.idx = idx;
			this.x=x;
			this.y=y;
			this.z=z;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int from,to,dist;
		
		Edge(int from, int to, int dist) {
			this.from=from;
			this.to=to;
			this.dist=dist;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(dist, e.dist);
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,x,y,z,cnt;
	static long ans;
	static int[] p;
	static Planet[] planets;
	static List<Edge> edges = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		planets = new Planet[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			planets[i] = new Planet(i,x,y,z);
		}
		Arrays.sort(planets, (a,b) -> a.x-b.x);
		for(int i=0; i<N-1; i++) {
			edges.add(new Edge(planets[i].idx, planets[i+1].idx, Math.abs(planets[i].x - planets[i+1].x)));
		}
		Arrays.sort(planets, (a,b) -> a.y-b.y);
		for(int i=0; i<N-1; i++) {
			edges.add(new Edge(planets[i].idx, planets[i+1].idx, Math.abs(planets[i].y - planets[i+1].y)));
		}
		Arrays.sort(planets, (a,b) -> a.z-b.z);
		for(int i=0; i<N-1; i++) {
			edges.add(new Edge(planets[i].idx, planets[i+1].idx, Math.abs(planets[i].z - planets[i+1].z)));
		}
		Collections.sort(edges);
		p = new int[N];
		for(int i=0; i<N; i++) p[i]=i;
		for(Edge e : edges) {
			if(union(e.from,e.to)) {
				ans+=e.dist;
				if(++cnt==N-1) break;
			}
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static boolean union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if(x==y) return false;
		p[y]=x;
		return true;
	}
	
	static int findSet(int x) {
		if(p[x]!=x) p[x]=findSet(p[x]);
		return p[x];
	}
}