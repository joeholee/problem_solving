import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static List<Edge> adj = new ArrayList<>();
	static long[] dist;
	static final long INF = Long.MAX_VALUE;
	
	static class Edge {
		int from,to,weight;
		
		Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adj.add(new Edge(from,to,weight));
		}
		dist = new long[N+1];
		Arrays.fill(dist, INF);
		dist[1]=0;
		for(int i=1; i<=N; i++) {
			for(Edge edge : adj) {
				if(dist[edge.from]==INF) continue;
				if(dist[edge.to]>dist[edge.from]+edge.weight) {
					dist[edge.to]=dist[edge.from]+edge.weight;
					if(i==N) {
						System.out.println(-1);
						System.exit(0);
					}
				}
			}
		}
		for(int i=2; i<=N; i++) sb.append(dist[i]==INF ? -1 : dist[i]).append('\n');
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}