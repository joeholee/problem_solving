import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n,m,start,end;
	static final int INF = Integer.MAX_VALUE;
	static List<List<Edge>> adj = new ArrayList<>();
	static int[] dist;
	static int[] prev;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		dist = new int[n+1];
		prev = new int[n+1];
		Arrays.fill(dist, INF);
		Arrays.fill(prev, -1);
		for(int i=0; i<=n; i++) adj.add(new ArrayList<>());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adj.get(from).add(new Edge(to,cost));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		dijkstra();
		sb.append(dist[end]).append('\n');
		List<Integer> path = new ArrayList<>();
		for(int cur=end; cur!=-1; cur=prev[cur]) path.add(cur);
		Collections.reverse(path);
		sb.append(path.size()).append('\n');
		for(int i=0; i<path.size(); i++) sb.append(path.get(i)).append(' ');
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start,0));
		dist[start]=0;
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(dist[cur.to]!=cur.cost) continue;
			for(Edge edge : adj.get(cur.to)) {
				if(dist[edge.to]>dist[cur.to]+edge.cost) {
					dist[edge.to] = dist[cur.to]+edge.cost;
					prev[edge.to] = cur.to;
					pq.add(new Edge(edge.to, dist[edge.to]));
				}
			}
		}
	}
	
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
}