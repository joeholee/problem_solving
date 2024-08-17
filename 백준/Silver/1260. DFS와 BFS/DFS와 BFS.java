import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
	static int N,M,V;
	static boolean[] vis;
	static int[][] arr;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1=Integer.parseInt(st.nextToken());
			int v2=Integer.parseInt(st.nextToken());
			arr[v1][v2]=1;
			arr[v2][v1]=1;
		}
		// sort
		vis = new boolean[N+1];
		dfs(V);
		Arrays.fill(vis,false);
		sb.setLength(0);
		bfs(V);
	}
	
	static void dfs(int V) {
		Stack<Integer> st = new Stack<>();
		st.push(V);
		while(!st.isEmpty()) {
			int tmp = st.pop();
			if(!vis[tmp]) {
				sb.append(tmp+" ");
				vis[tmp]=true;
				for(int i=N; i>0; i--) {
					if(!vis[i] && arr[tmp][i]==1) st.push(i);
				}
			}
		}
		System.out.println(sb);
	}
	
	static void bfs(int V) {
		Queue<Integer> q = new LinkedList<>();
		q.add(V);
		sb.append(V+" ");
		vis[V]=true;
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i=1; i<=N; i++) {
				if(arr[tmp][i]==1 && !vis[i]) {
					q.add(i);
					vis[i]=true;
					sb.append(i+" ");
				}
			}
		}
		System.out.println(sb);
	}
}