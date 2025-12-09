import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T,n,d,c;
	static int[] dist;
	static List<List<Edge>> adj;
	static final int INF = 100000000;
	
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
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			dist = new int[n+1];
			adj = new ArrayList<>();
			for(int i=0; i<=n; i++) adj.add(new ArrayList<>());
			Arrays.fill(dist, INF);
			for(int i=0; i<d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				adj.get(b).add(new Edge(a,s));
			}
			dijkstra(c);
			int max=-1, cnt=0;
			for(int i : dist) {
				if(i==INF) continue;
				max = Math.max(max, i);
				cnt++;
			}
			sb.append(cnt).append(' ').append(max).append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void dijkstra(int start) {
		dist[start]=0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start,0));
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(cur.weight!=dist[cur.to]) continue;
			for(Edge e : adj.get(cur.to)) {
				if(dist[e.to]>dist[cur.to]+e.weight) {
					dist[e.to]=dist[cur.to]+e.weight;
					pq.offer(new Edge(e.to,dist[e.to]));
				}
			}
		}
	}
}