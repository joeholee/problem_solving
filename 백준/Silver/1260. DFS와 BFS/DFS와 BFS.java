import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M,V;
	static int[][] arr;
	static boolean[] vis;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			arr[v1][v2]=1;
			arr[v2][v1]=1;
		}
		vis = new boolean[N+1];
		dfs(V);
		System.out.println(sb);
		Arrays.fill(vis, false);
		sb.setLength(0);
		bfs(V);
		System.out.println(sb);
	}
	
	static void dfs(int V) {
		vis[V]=true;
		sb.append(V).append(' ');
		for(int i=1; i<=N; i++) if(arr[V][i]==1 && !vis[i]) dfs(i);
	}
	
	static void bfs(int V) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(V);
		sb.append(V).append(' ');
		vis[V]=true;
		while(!q.isEmpty()) {
			int tmp=q.poll();
			for(int i=1; i<=N; i++) {
				if(arr[tmp][i]==1 && !vis[i]) {
					q.offer(i);
					vis[i]=true;
					sb.append(i).append(' ');
				}
			}
		}
	}
}