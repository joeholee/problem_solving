import java.io.*;
import java.util.*;

public class Main {
	
	static class Bus implements Comparable<Bus> {
		int to,cost;
		
		Bus(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Bus b) {
			return Integer.compare(cost, b.cost);
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M,start,end;
	static int[] dist;
	static List<List<Bus>> adj = new ArrayList<>();
	static PriorityQueue<Bus> pq = new PriorityQueue<>();
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<=N; i++) adj.add(new ArrayList<>());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adj.get(from).add(new Bus(to,cost));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		dijkstra(start);
		bw.write(dist[end]+"");
		bw.close();
		br.close();
	}
	
	static void dijkstra(int start) {
		dist[start]=0;
		pq.add(new Bus(start,0));
		while(!pq.isEmpty()) {
			Bus cur = pq.poll();
			if(dist[cur.to]!=cur.cost) continue;
			for(Bus b : adj.get(cur.to)) {
				if(dist[b.to]>dist[cur.to]+b.cost) {
					dist[b.to]=dist[cur.to]+b.cost;
					pq.add(new Bus(b.to,dist[b.to]));
				}
			}
		}
	}
}