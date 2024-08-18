import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n,u,v,m,start,end;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] vis;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		vis = new int[n+1];
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		dfs(start);
		System.out.println(vis[end]!=0 ? vis[end] : -1);
	}
	
	static void dfs(int start) {
		if(start==end) return;
		for(int i=0; i<graph.get(start).size(); i++) {
			int nxt = graph.get(start).get(i);
			if(vis[nxt]==0) {
				vis[nxt]=vis[start]+1;
				dfs(nxt);
			}
		}
	}
}