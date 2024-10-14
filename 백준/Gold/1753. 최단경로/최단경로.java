import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	static class Edge implements Comparable<Edge>{
		int to, weight;
		
		public Edge(int to, int weight) {
			this.to=to;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(weight, e.weight);
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V,E,K;
	static List<Edge>[] adjList;
	static int[] dist;
	static boolean[] vis;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		adjList = new ArrayList[V+1];
		for(int i=0; i<=V; i++) {
			adjList[i] = new ArrayList<>();
		}
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		vis = new boolean[V+1];
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[u].add(new Edge(v,w));
		}
		dijkstra(K);
		for(int i=1; i<=V; i++) {
			sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dijkstra(int start) {
		dist[start]=0;
		pq.add(new Edge(start,0));
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(vis[cur.to]) continue;
			vis[cur.to]=true;
			for(Edge edge : adjList[cur.to]) {
				if(!vis[edge.to] && dist[edge.to] > dist[cur.to]+edge.weight) {
					dist[edge.to] = dist[cur.to]+edge.weight;
					pq.add(new Edge(edge.to, dist[edge.to]));
				}
			}
		}
	}
}