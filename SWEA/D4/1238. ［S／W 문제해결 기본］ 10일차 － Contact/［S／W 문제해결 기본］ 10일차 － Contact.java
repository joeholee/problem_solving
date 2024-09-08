import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,start,cur,ans;
	static int[] vis;
	static int[][] graph;
	static Queue<Integer> q;
	
	public static void main(String args[]) throws Exception
	{
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			String[] sz = br.readLine().split(" ");
			N = Integer.parseInt(sz[0]);
			start = Integer.parseInt(sz[1]);
			graph = new int[101][101];
			vis = new int[101];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph[from][to]=1;
			}
			bfs(start);
			sb.append("#").append(test_case).append(" ").append(ans);
			System.out.println(sb);
			sb.setLength(0);
			ans=0;
		}
	}
	
	static void bfs(int v) {
		q = new LinkedList<>();
		int tmp=0;
		q.add(v);
		vis[v]=1;
		while(!q.isEmpty()) {
			cur = q.poll();
			for(int i=1; i<=100; i++) {
				if(graph[cur][i]==1 && vis[i]==0) {
					q.add(i);
					vis[i]=vis[cur]+1;
				}
			}
			tmp = Math.max(tmp,vis[cur]);
		}
		for(int i=100; i>=1; i--) {
			if(vis[i]==tmp) {
				ans=i;
				return;
			}
		}
	}
}