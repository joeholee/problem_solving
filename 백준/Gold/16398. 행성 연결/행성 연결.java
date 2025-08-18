import java.io.*;
import java.util.*;

public class Main {
	
	static class Edge implements Comparable<Edge> {
		int to,weight;
		
		Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(weight,e.weight); 
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,cnt;
	static long ans;
	static boolean[] vis;
	static List<List<Edge>> adj = new ArrayList<>();
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		vis = new boolean[N];
		for(int i=0; i<N; i++) {
			adj.add(new ArrayList<>());
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				adj.get(i).add(new Edge(j,Integer.parseInt(st.nextToken())));
			}
		}
		prim(0);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void prim(int start) {
		pq.add(new Edge(start,0));
		while(!pq.isEmpty() && cnt<N) {
			Edge cur = pq.poll();
			if(vis[cur.to]) continue;
			vis[cur.to]=true;
			ans+=cur.weight;
			cnt++;
			for(Edge e : adj.get(cur.to)) {
				if(!vis[e.to]) pq.add(e);
			}
		}
	}
}