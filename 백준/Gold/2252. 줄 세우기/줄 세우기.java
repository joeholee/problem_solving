import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static int[] degree;
	static List<List<Integer>> adj = new ArrayList<>();
	static Queue<Integer> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		degree = new int[N+1];
		for(int i=0; i<=N; i++) adj.add(new ArrayList<>());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj.get(a).add(b);
			degree[b]++;
		}
		for(int i=1; i<=N; i++) if(degree[i]==0) q.offer(i);
		solve();
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void solve() {
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(' ');
			for(int nxt : adj.get(cur)) {
				if(--degree[nxt]==0) q.offer(nxt);
			}
		}
	}
}