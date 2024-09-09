import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V,E;
	static int[][] task;
	static int[] degree;
	static boolean[] vis;
	static Stack<Integer> ans;
	
	public static void main(String args[]) throws Exception
	{
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			sb.append("#").append(test_case).append(" ");
			String[] sz = br.readLine().split(" ");
			V = Integer.parseInt(sz[0]);
			E = Integer.parseInt(sz[1]);
			task = new int[V+1][V+1];
			degree = new int[V+1];
			vis = new boolean[V+1];
			ans = new Stack<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				task[from][to]=1;
				degree[to]++;
			}
			for(int i=1; i<=V; i++) {
				if(degree[i]==0) dfs(i);
			}
			while(!ans.empty()) sb.append(ans.pop()).append(" ");
			System.out.println(sb);
			sb.setLength(0);
		}
	}
	
	static void dfs(int cur) {
		vis[cur]=true;
		for(int i=1; i<=V; i++) {
			if(task[cur][i]==1 && !vis[i]) dfs(i);
		}
		ans.push(cur);
	}
}