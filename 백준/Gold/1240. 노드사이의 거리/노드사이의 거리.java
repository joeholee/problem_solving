import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static List<List<Node>> adj = new ArrayList<>();
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<=N; i++) adj.add(new ArrayList<>());
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			adj.get(from).add(new Node(to,dist));
			adj.get(to).add(new Node(from,dist));
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			calc(from);
			sb.append(dist[to]).append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void calc(int from) {
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[from]=0;
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(from,0));
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(Node node : adj.get(cur.to)) {
				if(dist[node.to]>dist[cur.to]+node.dist) {
					dist[node.to] = dist[cur.to]+node.dist;
					q.offer(new Node(node.to,dist[node.to]));
				}
			}
		}
	}
	
	static class Node {
		int to,dist;
		
		Node(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}
	}
}