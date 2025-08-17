import java.io.*;
import java.util.*;

public class Main {
	static class Road implements Comparable<Road> {
		int to,time;
		
		Road(int to, int time) {
			this.to=to;
			this.time=time;
		}
		
		@Override
		public int compareTo(Road r) {
			return Integer.compare(time, r.time);
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static List<List<Road>> adj = new ArrayList<>();
	static List<List<Road>> rev = new ArrayList<>();
	static PriorityQueue<Road> pq = new PriorityQueue<>();
	static int[] distTo, distFrom;
	static int N,M,X,ans;
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken()); // destination
		for(int i=0; i<=N; i++) {
			adj.add(new ArrayList<>());
			rev.add(new ArrayList<>());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			adj.get(from).add(new Road(to,time));
			rev.get(to).add(new Road(from,time));
		}
		distTo = dijkstra(X,adj);
		distFrom = dijkstra(X,rev);
		for(int i=1; i<=N; i++) {
			ans = Math.max(ans, distTo[i]+distFrom[i]);
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static int[] dijkstra(int start, List<List<Road>> graph) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start]=0;
		pq.add(new Road(start,0));
		while(!pq.isEmpty()) {
			Road cur = pq.poll();
			if(dist[cur.to]!=cur.time) continue;
			for(Road road : graph.get(cur.to)) {
				if(dist[road.to]>dist[cur.to]+road.time) {
					dist[road.to]=dist[cur.to]+road.time;
					pq.add(new Road(road.to,dist[road.to]));
				}
			}
		}
		return dist;
	}
}