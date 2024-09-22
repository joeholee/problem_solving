import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static ArrayList<ArrayList<Integer>> adjList;
	static int[] degree;
	static StringBuilder sb = new StringBuilder();
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adjList = new ArrayList<>();
		for(int i=0; i<=N; i++) adjList.add(new ArrayList<>());
		degree = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adjList.get(A).add(B);
			degree[B]++;
		}
		for(int i=1; i<=N; i++) {
			if(degree[i]==0) q.add(i);
		}
		solve();
	}
	
	static void solve() {
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			for(int nxt : adjList.get(cur)) {
				degree[nxt]--;
				if(degree[nxt]==0) q.add(nxt);
			}
		}
		System.out.println(sb);
	}
}