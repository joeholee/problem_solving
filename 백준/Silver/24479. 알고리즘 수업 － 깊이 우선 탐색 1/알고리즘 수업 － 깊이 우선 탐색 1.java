import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N,M,R,u,v,cnt; // cnt <- 몇번째로 방문했나 기록
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] vis;
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		vis = new int[N+1];
		for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		for(ArrayList<Integer> list : graph) Collections.sort(list);
		cnt=1;
		DFS(R);
		for(int i=1; i<=N; i++) System.out.println(vis[i]);
	}
	
	static void DFS(int R) {
		vis[R]=cnt;
		for(int i=0; i<graph.get(R).size(); i++) {
			int nxt = graph.get(R).get(i);
			if(vis[nxt]==0) {
				cnt++;
				DFS(nxt);
			}
		}
	}
}