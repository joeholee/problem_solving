import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge> {
		int u,v,w;
		
		Edge(int u, int v, int w) {
			this.u=u;
			this.v=v;
			this.w=w;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(w, e.w);
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T,N,M,p,q,cnt;
	static boolean possible;
	static int[] parent;
	static List<Edge> edges;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			edges = new ArrayList<>();
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				edges.add(new Edge(u,v,w));
			}
			cnt=0;
			possible=false;
			parent = new int[N+1];
			for(int i=1; i<=N; i++) parent[i]=i;
			Collections.sort(edges);
			for(Edge e : edges) {
				if(findSet(e.u)!=findSet(e.v)) {
					union(e.u, e.v);
					cnt++;
					if((e.u==p && e.v==q) || (e.u==q && e.v==p)) possible=true;
				}
				if(cnt==N-1) break;
			}
			sb.append(possible ? "YES" : "NO").append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void union(int a, int b) {
		parent[findSet(b)] = parent[a];
	}
	
	static int findSet(int x) {
		if(parent[x]!=x) parent[x]=findSet(parent[x]);
		return parent[x];
	}
}