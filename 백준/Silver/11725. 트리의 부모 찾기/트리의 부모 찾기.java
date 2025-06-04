import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] parent;
	static boolean[] vis;
	static ArrayList<Integer>[] list;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		vis = new boolean[N+1];
		list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) list[i] = new ArrayList<>();
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		dfs(1);
		for(int i=2; i<=N; i++) sb.append(parent[i]).append('\n');
		System.out.println(sb);
	}
	
	static void dfs(int idx) {
		vis[idx] = true;
		for(int i : list[idx]) {
			if(!vis[i]) {
				parent[i] = idx;
				dfs(i);
			}
		}
	}
}