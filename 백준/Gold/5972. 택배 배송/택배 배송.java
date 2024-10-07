import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int[] dist;
	static boolean[] vis;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static final int INF=987654321;
	static List<Node>[] adjList;
	
	static class Node implements Comparable<Node>{
		int B,C;
		
		Node(int B, int C) {
			this.B=B;
			this.C=C;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(C, o.C);
		}
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N+1];
		for(int i=0; i<=N; i++) adjList[i]=new ArrayList<>();
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			adjList[A].add(new Node(B,C));
			adjList[B].add(new Node(A,C));
		}
		dijkstra(1);
		System.out.println(dist[N]);
	}
	
	static void dijkstra(int start) {
		vis = new boolean[N+1];
		dist[start]=0;
		pq.add(new Node(start, 0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(vis[cur.B]) continue;
			vis[cur.B]=true;
			for(Node node : adjList[cur.B]) {
				if(!vis[node.B] && dist[node.B]>dist[cur.B]+node.C) {
					dist[node.B]=dist[cur.B]+node.C;
					pq.add(new Node(node.B, dist[node.B]));
				}
			}
		}
	}
}
