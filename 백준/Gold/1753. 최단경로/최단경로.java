import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V,E,K,u,v,w,dist[];
	static List<List<Edge>> adj = new ArrayList<>();
	static final int INF = 987654321;
	
	static class Edge implements Comparable<Edge> {
		int v,w;
		
		Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(w, e.w);
		}
	}
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		for(int i=0; i<=V; i++) adj.add(new ArrayList<>());
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			adj.get(u).add(new Edge(v,w));
		}
		dist = new int[V+1];
		Arrays.fill(dist,INF);
		dist[K]=0;
		dijkstra(K);
		for(int i=1; i<=V; i++) sb.append(dist[i]==INF ? "INF" : dist[i]).append('\n');
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void dijkstra(int K) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(K,0));
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(dist[cur.v]!=cur.w) continue;
			for(Edge e : adj.get(cur.v)) {
				if(dist[e.v]>dist[cur.v]+e.w) {
					dist[e.v]=dist[cur.v]+e.w;
					pq.offer(new Edge(e.v,dist[e.v]));
				}
			}
		}
	}
}