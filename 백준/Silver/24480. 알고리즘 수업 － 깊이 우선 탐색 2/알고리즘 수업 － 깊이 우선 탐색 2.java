import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M,R,cur=1;
	static List<List<Integer>> adj = new ArrayList<>();
	static boolean[] vis;
	static int[] order;
 	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		for(int i=0; i<=N; i++) adj.add(new ArrayList<>());
		vis = new boolean[N+1];
		order = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		for(int i=0; i<=N; i++) Collections.sort(adj.get(i), Collections.reverseOrder());
		dfs(R);
		for(int i=1; i<=N; i++) sb.append(order[i]).append('\n');
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void dfs(int start) {
		vis[start]=true;
		order[start]=cur++;
		for(int nxt : adj.get(start)) {
			if(!vis[nxt]) dfs(nxt);
		}
	}
}