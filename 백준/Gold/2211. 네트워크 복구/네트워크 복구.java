import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static List<List<Edge>> adj = new ArrayList<>();
	static int[] dist,prev;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<=N; i++) adj.add(new ArrayList<>());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			adj.get(A).add(new Edge(B,C));
			adj.get(B).add(new Edge(A,C));
		}
		dist = new int[N+1];
		prev = new int[N+1];
		Arrays.fill(dist, INF);
		dijkstra();
		sb.append(N-1).append('\n');
		for(int i=2; i<=N; i++) sb.append(i).append(" ").append(prev[i]).append('\n');
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void dijkstra() {
		dist[1]=0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1,0));
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(dist[cur.to]!=cur.time) continue;
			for(Edge edge : adj.get(cur.to)) {
				if(dist[edge.to]>dist[cur.to]+edge.time) {
					dist[edge.to]=dist[cur.to]+edge.time;
					prev[edge.to]=cur.to;
					pq.offer(new Edge(edge.to, dist[edge.to]));
				}
			}
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int to,time;
		
		Edge(int to, int time) {
			this.to = to;
			this.time = time;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(time, e.time);
		}
	}
}