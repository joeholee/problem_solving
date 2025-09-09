import java.io.*;
import java.util.*;

public class Main {
	
	static class Edge implements Comparable<Edge> {
		int to,weight;
		
		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(weight, e.weight);
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n,m,s,t;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;
	static List<List<Edge>> adj = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dist = new int[n+1];
		for(int i=0; i<=n; i++) adj.add(new ArrayList<>());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj.get(a).add(new Edge(b,c));
			adj.get(b).add(new Edge(a,c));
		}
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		dijkstra(s);
		bw.write(dist[t]+"");
		bw.close();
		br.close();
	}
	
	static void dijkstra(int start) {
		Arrays.fill(dist, INF);
		dist[start]=0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start,0));
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(dist[cur.to]!=cur.weight) continue;
			for(Edge edge : adj.get(cur.to)) {
				if(dist[edge.to]>dist[cur.to]+edge.weight) {
					dist[edge.to]=dist[cur.to]+edge.weight;
					pq.offer(new Edge(edge.to, dist[edge.to]));
				}
			}
		}
	}
}