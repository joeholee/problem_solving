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
	static StringBuilder sb = new StringBuilder();
	static int[] degree,cost,ans;
	static Queue<Integer> q = new LinkedList<>();
	static ArrayList<ArrayList<Integer>> adjList;
	static int N;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		degree = new int[N+1];
		cost = new int[N+1];
		ans = new int[N+1];
		adjList = new ArrayList<>();
		for(int i=0; i<=N; i++) adjList.add(new ArrayList<>());
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i] = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				int nxt = Integer.parseInt(st.nextToken());
				if(nxt==-1) break;
				adjList.get(nxt).add(i);
				degree[i]++;
			}
		}
		for(int i=1; i<=N; i++) {
			if(degree[i]==0) q.add(i);
			ans[i]=cost[i];
		}
		solve();
	}
	
	static void solve() {
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int nxt : adjList.get(cur)) {
				degree[nxt]--;
				ans[nxt] = Math.max(ans[nxt], ans[cur]+cost[nxt]);
				if(degree[nxt]==0) q.add(nxt);
			}
		}
		for(int i=1; i<=N; i++) sb.append(ans[i]).append("\n");
		System.out.println(sb);
	}
}