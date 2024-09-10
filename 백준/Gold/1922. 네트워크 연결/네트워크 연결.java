import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

class Edge implements Comparable<Edge> {
	int a,b,c;
	
	Edge(int a, int b, int c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	@Override
	public int compareTo(Edge e) {
		return Integer.compare(c, e.c);
	}
}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M,num,ans;
	static int[] p;
	static Edge[] edges;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		edges = new Edge[M];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(a,b,c);
		}
		p = new int[N+1];
		for(int i=1; i<=N; i++) p[i]=i; // make
		Arrays.sort(edges);
		for(int i=0; i<M; i++) {
			int a = edges[i].a;
			int b = edges[i].b;
			if(find(a)!=find(b)) {
				union(a,b);
				ans+=edges[i].c;
				num++;
			}
			if(num==N-1) break;
		}
		System.out.println(ans);
	}
	
	static void union(int a, int b) {
		p[find(b)]=find(a);
	}
	
	static int find(int x) {
		if(x!=p[x]) p[x]=find(p[x]);
		return p[x];
	}
}