import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N,M,a,b,ans;
	static int[] p; // 대표자 집합
	
	public static void main(String args[]) throws Exception
	{
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#").append(test_case).append(" ");
			String[] sz = br.readLine().split(" ");
			N = Integer.parseInt(sz[0]);
			M = Integer.parseInt(sz[1]);
			p = new int[N+1];
			for(int i=1; i<=N; i++) p[i]=i; // makeSet
			for(int i=0; i<M; i++) {
				String[] input = br.readLine().split(" ");
				a = Integer.parseInt(input[0]);
				b = Integer.parseInt(input[1]);
				union(a,b);
			}
			for(int i=1; i<=N; i++) if(i==p[i]) ans++;
			sb.append(ans); 
			System.out.println(sb);
			sb.setLength(0);
			ans=0;
		}
	}
	
	static void union(int a, int b) {
		p[findSet(b)]=findSet(a);
	}
	
	static int findSet(int x) {
		if(p[x]!=x) p[x]=findSet(p[x]);
		return p[x];
	}
}