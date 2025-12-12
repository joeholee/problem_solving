import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M,K,num;
	static long max;
	static long[] dist;
	static int[] cand;
	static List<List<Edge>> adj = new ArrayList<>();
	static final long INF = 100_000_000_000L;
	
	static class Edge implements Comparable<Edge> {
		int to;
		long dist;
		
		Edge(int to, long dist) {
			this.to = to;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Long.compare(dist, e.dist);
		}
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int i=0; i<=N; i++) adj.add(new ArrayList<>());
		dist = new long[N+1];
		cand = new int[K];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			adj.get(V).add(new Edge(U,C));
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) cand[i] = Integer.parseInt(st.nextToken());
		dijkstra();
		sb.append(num).append('\n').append(max);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Arrays.fill(dist, INF);
		for(int i : cand) {
			dist[i]=0;
			pq.offer(new Edge(i,0));
		}
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(dist[cur.to]!=cur.dist) continue;
			for(Edge e : adj.get(cur.to)) {
				if(dist[e.to]>dist[cur.to]+e.dist) {
					dist[e.to]=dist[cur.to]+e.dist;
					pq.offer(new Edge(e.to, dist[e.to]));
				}
			}
		}
		for(int i=1; i<=N; i++) {
			if(dist[i]>max&&dist[i]!=INF) {
				max=dist[i];
				num=i;
			}
		}
	}
}