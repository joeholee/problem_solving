import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static List<List<Integer>> adj = new ArrayList<>();
	static Queue<Integer> q = new ArrayDeque<>();
	static int[] degree,ans;
	static int N,M;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<=N; i++) adj.add(new ArrayList<>());
		degree = new int[N+1];
		ans = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adj.get(A).add(B);
			degree[B]++;
		}
		solve();
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void solve() {
		for(int i=1; i<=N; i++) {
			if(degree[i]==0) q.offer(i);
			ans[i]=1;
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int nxt : adj.get(cur)) {
				if(--degree[nxt]==0) {
					q.offer(nxt);
					ans[nxt]=ans[cur]+1;
				}
			}
		}
		for(int i=1; i<=N; i++) sb.append(ans[i]).append(' ');
	}
}