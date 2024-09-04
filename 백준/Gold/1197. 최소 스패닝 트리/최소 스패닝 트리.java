import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	static class Edge implements Comparable<Edge> {
		int from,to,val;
		
		Edge(int from,int to,int val) {
			this.from=from;
			this.to=to;
			this.val=val;
		}
		
		public int compareTo(Edge o) {
			return this.val-o.val;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int V,E,A,B,C,pick,ans;
	static int[] p;
	static Edge[] edges;
	
	public static void main(String[] args) throws IOException {
		String[] sz = br.readLine().split(" ");
		V = Integer.parseInt(sz[0]);
		E = Integer.parseInt(sz[1]);
		p = new int[V+1];
		for(int i=1; i<=V; i++) p[i]=i; // makeSet
		edges = new Edge[E];
		for(int i=0; i<E; i++) {
			String[] input = br.readLine().split(" ");
			A = Integer.parseInt(input[0]);
			B = Integer.parseInt(input[1]);
			C = Integer.parseInt(input[2]);
			edges[i] = new Edge(A,B,C);
		}
		Arrays.sort(edges);
		for(int i=0; i<E; i++) {
			int a = edges[i].from;
			int b = edges[i].to;
			if(findSet(a)!=findSet(b)) {
				union(a,b);
				ans+=edges[i].val;
				pick++;
			}
			if(pick==V-1) break;
		}
		System.out.println(ans);
	}
	
	static void union(int a,int b) {
		p[findSet(b)]=p[a];
	}
	
	static int findSet(int x) {
		if(p[x]!=x) p[x]=findSet(p[x]);
		return p[x];
	}
	
}