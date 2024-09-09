import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;


class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V,E;
	static int[][] task;
	static int[] degree;
	static Queue<Integer> q;
	
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
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				task[from][to]=1;
				degree[to]++;
			}
			q = new LinkedList<>();
			for(int i=1; i<=V; i++) {
				if(degree[i]==0) q.add(i);
			}
			while(!q.isEmpty()) {
				int cur = q.poll();
				sb.append(cur).append(" ");
				for(int i=1; i<=V; i++) {
					if(task[cur][i]==1) {
						degree[i]--;
						task[cur][i]=0;
						if(degree[i]==0) q.add(i);
					}
				}
			}
			System.out.println(sb);
			sb.setLength(0);
		}
	}
}