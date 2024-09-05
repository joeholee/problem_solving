import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution
{
	static class Edge implements Comparable<Edge> {
		int from,to;
		double cost;
		
		Edge(int from, int to, double cost) {
			this.from=from;
			this.to=to;
			this.cost=cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.cost,o.cost);
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N,pick;
	static int[] p; // 대표자 배열
	static long[] X,Y;
	static double E,cost,ans;
	static Edge[] edges;
	
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			X = new long[N];
			Y = new long[N];
			String[] x = br.readLine().split(" ");
			String[] y = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				X[i] = Long.parseLong(x[i]);
				Y[i] = Long.parseLong(y[i]);
			}
			E = Double.parseDouble(br.readLine());
			p = new int[N];
			for(int i=0; i<N; i++) p[i]=i; // makeSet
			edges = new Edge[N*(N-1)/2];
			int tmp=0;
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					double cost = ((X[i]-X[j])*(X[i]-X[j])+(Y[i]-Y[j])*(Y[i]-Y[j]))*E;
					edges[tmp++] = new Edge(i,j,cost);
				}
			}
			Arrays.sort(edges); // 가중치 오름차순 정렬
			for(int i=0; i<N*(N-1)/2; i++) {
				int a = edges[i].from;
				int b = edges[i].to;
				if(findSet(a)!=findSet(b)) {
					union(a,b);
					ans+=edges[i].cost;
					pick++;
				}
				if(pick==(N-1)) break;
			}
			sb.append("#").append(test_case).append(" ").append(Math.round(ans));
			System.out.println(sb);
			sb.setLength(0);
			pick=0;
			ans=0;
		}
	}
	
	static int findSet(int x) {
		if(p[x]!=x) p[x]=findSet(p[x]);
		return p[x];
	}
	
	static void union(int a, int b) {
		p[findSet(b)] = p[a];
	}
} 