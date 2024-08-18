import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N,E,u,v,cnt,ans;
	static boolean[] vis;
	static ArrayList<ArrayList<Integer>> graph;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		E = Integer.parseInt(st.nextToken());
		vis = new boolean[N+1];
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) graph.add(new ArrayList<Integer>());
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		for(ArrayList<Integer> list : graph) Collections.sort(list);
		DFS(1);
		System.out.println(ans);
	}
	
	static void DFS(int R) {
		vis[R]=true;
		for(int i=0; i<graph.get(R).size(); i++) {
			int nxt = graph.get(R).get(i);
			if(!vis[nxt]) {
				ans++;
				DFS(nxt);
			}
		}
	}
}