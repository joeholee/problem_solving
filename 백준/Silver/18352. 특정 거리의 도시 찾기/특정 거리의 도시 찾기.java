import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N,M,K,X;
	static final int INF = Integer.MAX_VALUE;
	static List<List<Integer>> adj = new ArrayList<>();
	static Queue<Integer> q = new ArrayDeque<>();
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		for(int i=0; i<=N; i++) adj.add(new ArrayList<>());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adj.get(A).add(B);
		}
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		q.add(X);
		dist[X]=0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int nxt : adj.get(cur)) {
				if(dist[nxt]==INF) {
					dist[nxt]=dist[cur]+1;
					q.add(nxt);
				}
			}
		}
		for(int i=1; i<=N; i++) {
			if(dist[i]==K) {
				sb.append(i).append('\n');
			}
		}
		if(sb.length()==0) sb.append(-1);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}