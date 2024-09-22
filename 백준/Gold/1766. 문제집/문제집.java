import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static ArrayList<ArrayList<Integer>> adjList;
	static int[] degree;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	
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
		for(int i=1; i<=N; i++) if(degree[i]==0) pq.add(i);
		solve();
	}
	
	static void solve() {
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			sb.append(cur).append(" ");
			for(int nxt : adjList.get(cur)) {
				degree[nxt]--;
				if(degree[nxt]==0) pq.add(nxt);
			}
		}
		System.out.println(sb);
	}
}