import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M,t,ans,pick;
	static int[] p;
	static Edge[] edges;
	
	static class Edge implements Comparable<Edge> {
		int from, to, cost;
		
		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(cost, e.cost);
		}
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		edges = new Edge[M];
		for(int i=0; i<=N; i++) p[i]=i;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(A,B,C);
		}
		Arrays.sort(edges);
		for(int i=0; i<M; i++) {
			int from = edges[i].from;
			int to = edges[i].to;
			if(findSet(from)!=findSet(to)) {
				union(from,to);
				ans+=edges[i].cost+pick*t;
				pick++;
			}
			if(pick==N-1) break;
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static int findSet(int x) {
		if(p[x]!=x) p[x] = findSet(p[x]);
		return p[x];
	}
	
	static void union(int a, int b) {
		p[findSet(b)] = p[a];
	}
}