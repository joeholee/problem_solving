import java.io.*;
import java.util.*;

public class Main {
	
	static class Edge implements Comparable<Edge> {
		int to,weight;
		
		Edge(int to, int weight) {
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
	static int V,E,A,B,C,cnt;
	static List<List<Edge>> adj = new ArrayList<>();
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static boolean[] vis;
	static long ans;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		for(int i=0; i<=V; i++) adj.add(new ArrayList<>());
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			adj.get(A).add(new Edge(B,C));
			adj.get(B).add(new Edge(A,C));
		}
		vis = new boolean[V+1];
		prim(1);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void prim(int start) {
		pq.add(new Edge(start,0));
		while(!pq.isEmpty() && cnt<V) {
			Edge cur = pq.poll();
			if(vis[cur.to]) continue;
			vis[cur.to]=true;
			ans+=cur.weight;
			cnt++;
			for(Edge e: adj.get(cur.to)) {
				if(!vis[e.to]) pq.add(e);
			}
		}
	}
}