import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M,start,end;
	static int dist[];
	static List<List<Bridge>> adj = new ArrayList<>();
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
			adj.get(A).add(new Bridge(B,C));
			adj.get(B).add(new Bridge(A,C));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		dijkstra();
		bw.write(dist[end]+"");
		bw.close();
		br.close();
	}
	
	static void dijkstra() {
		dist = new int[N+1];
		PriorityQueue<Bridge> pq = new PriorityQueue<>();
		pq.offer(new Bridge(start,INF));
		dist[start]=INF;
		while(!pq.isEmpty()) {
			Bridge cur = pq.poll();
			if(dist[cur.to]!=cur.weight) continue;
			for(Bridge b : adj.get(cur.to)) {
				int cost = Math.min(dist[cur.to], b.weight);
				if(dist[b.to]<cost) {
					dist[b.to]=cost;
					pq.offer(new Bridge(b.to, dist[b.to]));
				}
			}
		}
	}
	
	static class Bridge implements Comparable<Bridge> {
		int to, weight;
		
		Bridge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Bridge b) {
			return Long.compare(b.weight, weight);
		}
	}
}