import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M,from,to,cost,A,B,dist[];
	static List<List<Edge>> adj = new ArrayList<>();
	static final int INF = 1098765432;
	
	static class Edge implements Comparable<Edge> {
		int to,cost;
		
		Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(cost, e.cost);
		}
	}
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<=N; i++) adj.add(new ArrayList<>());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			adj.get(from).add(new Edge(to,cost));
		}
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		dijkstra(A);
		bw.write(dist[B]+"");
		bw.close();
		br.close();
	}
	
	static void dijkstra(int A) {
		dist[A]=0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(A,0));
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(dist[cur.to]!=cur.cost) continue;
			for(Edge e : adj.get(cur.to)) {
				if(dist[e.to]>dist[cur.to]+e.cost) {
					dist[e.to]=dist[cur.to]+e.cost;
					pq.offer(new Edge(e.to,dist[e.to]));
				}
			}
		}
	}
}