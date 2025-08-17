import java.io.*;
import java.util.*;

public class Main {
	
	static class Edge implements Comparable<Edge> {
		int from,to,weight;
		
		Edge(int from, int to, int weight) {
			this.from=from;
			this.to=to;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(weight, e.weight);
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int V,E,A,B,C,pick,ans;
	static int[] p;
	static Edge[] edges;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		p = new int[V+1];
		for(int i=1; i<=V; i++) p[i]=i;
		edges = new Edge[E];
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(A,B,C);
		}
		Arrays.sort(edges);
		for(int i=0; i<E; i++) {
			int a = edges[i].from;
			int b = edges[i].to;
			if(findSet(a)!=findSet(b)) {
				union(a,b);
				ans+=edges[i].weight;
				pick++;
			}
			if(pick==V-1) break;
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void union(int a, int b) {
		p[findSet(b)] = p[a];
	}
	
	static int findSet(int x) {
		if(p[x]!=x) p[x]=findSet(p[x]);
		return p[x];
	}
}