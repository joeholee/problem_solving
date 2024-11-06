import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	static class Edge implements Comparable<Edge> {
		int u,v;
		double dist;
		
		Edge(int u, int v, double dist) {
			this.u=u;
			this.v=v;
			this.dist=dist;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Double.compare(dist, e.dist);
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,count;
	static double ans;
	static List<Edge> edges = new ArrayList<>();
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		double[][] stars = new double[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			stars[i][0] = Double.parseDouble(st.nextToken());
			stars[i][1] = Double.parseDouble(st.nextToken());
		}
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				double dist = getDistance(stars[i], stars[j]);
				edges.add(new Edge(i,j,dist));
			}
		}
		Collections.sort(edges);
		p = new int[n];
		for(int i=0; i<n; i++) p[i]=i;
		for(Edge edge : edges) {
			if(findSet(edge.u) != findSet(edge.v)) {
				union(edge.u, edge.v);
				ans += edge.dist;
				count++;
				if(count == n-1) break;
			}
		}
		System.out.printf("%.2f\n", ans);
	}
	
	static double getDistance(double[] star1, double[] star2) {
		double dx = star1[0]-star2[0];
		double dy = star1[1]-star2[1];
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	static int findSet(int x) {
		if(p[x]!=x) p[x]=findSet(p[x]);
		return p[x];
	}
	
	static void union(int a, int b) {
		p[findSet(b)] = findSet(a);
	}
}