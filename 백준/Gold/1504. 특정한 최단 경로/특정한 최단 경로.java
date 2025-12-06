import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,E,v1,v2,d1,d2,ans;
	static int[] dist;
	static boolean[] vis;
	static List<List<Edge>> adj = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		for(int i=0; i<=N; i++) adj.add(new ArrayList<>());
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj.get(a).add(new Edge(b,c));
			adj.get(b).add(new Edge(a,c));
		}
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		dist = new int[N+1];
		vis = new boolean[N+1];
		d1+=dijkstra(1,v1);
		d1+=dijkstra(v1,v2);
		d1+=dijkstra(v2,N);
		d2+=dijkstra(1,v2);
		d2+=dijkstra(v2,v1);
		d2+=dijkstra(v1,N);
		ans = (d1>=200000000 && d2>=200000000) ? -1 : Math.min(d1, d2);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static int dijkstra(int start, int end) {
		Arrays.fill(dist, 200000000);
		Arrays.fill(vis, false);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[start]=0;
		pq.offer(new Edge(start,0));
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(vis[cur.b]) continue;
			vis[cur.b]=true;
			for(Edge e : adj.get(cur.b)) {
				if(dist[e.b]>dist[cur.b]+e.c) {
					dist[e.b]=dist[cur.b]+e.c;
					pq.offer(new Edge(e.b, dist[e.b]));
				}
			}
		}
		return dist[end];
	}
	
	static class Edge implements Comparable<Edge> {
		int b,c;
		
		Edge(int b, int c) {
			this.b = b;
			this.c = c;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(c, e.c);
		}
	}
}