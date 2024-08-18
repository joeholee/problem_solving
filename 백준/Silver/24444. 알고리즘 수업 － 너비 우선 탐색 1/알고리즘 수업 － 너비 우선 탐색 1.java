import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Queue;

public class Main {
	static int N,M,R,u,v,cnt;
	static int[] vis;
	static ArrayList<ArrayList<Integer>> graph;
	static Queue<Integer> q = new LinkedList<>();
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		vis = new int[N+1];
		graph = new ArrayList<ArrayList<Integer>>();
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
		BFS(R);
		for(int i=1; i<=N; i++) System.out.println(vis[i]);
	}
	
	static void BFS(int R) {
		vis[R]=cnt++;
		q.add(R);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0; i<graph.get(cur).size(); i++) {
				int nxt = graph.get(cur).get(i);
				if(vis[nxt]!=0) continue;
				q.add(nxt);
				vis[nxt]=cnt++;
			}
		}
	}
}