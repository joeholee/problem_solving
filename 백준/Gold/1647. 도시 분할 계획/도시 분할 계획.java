import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	
	static class Edge implements Comparable<Edge> {
		int A,B,C;
		
		Edge(int A, int B, int C) {
			this.A=A;
			this.B=B;
			this.C=C;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(C, o.C);
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M,cnt,max,ans;
	static int[] p;
	static Edge[] edges;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edges = new Edge[M];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(A,B,C);
		}
		// sort
		Arrays.sort(edges);
		// makeSet
		p = new int[N+1];
		for(int i=1; i<=N; i++) p[i]=i;
		for(int i=0; i<M; i++) {
			if(findSet(edges[i].A)!=findSet(edges[i].B)) {
				unionSet(edges[i].A,edges[i].B);
				ans+=edges[i].C;
				cnt++;
				max=edges[i].C;
			}
			if(cnt==N-1) break;
		}
		System.out.println(ans-max);
	}
	
	static int findSet(int x) {
		if(p[x]!=x) p[x]=findSet(p[x]);
		return p[x];
	}
	
	static void unionSet(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
}