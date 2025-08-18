import java.io.*;
import java.util.*;

public class Main {
	
	static class Edge implements Comparable<Edge> {
		int from,to,weight;
		
		Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(weight,e.weight); 
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,cnt;
	static long ans;
	static int[] p;
	static List<Edge> adj = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		p = new int[N];
		for(int i=0; i<N; i++) {
			p[i]=i;
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				adj.add(new Edge(i,j,Integer.parseInt(st.nextToken())));
			}
		}
		Collections.sort(adj);
		for(Edge edge : adj) {
			if(findSet(edge.from)!=findSet(edge.to)) {
				union(edge.from, edge.to);
				ans+=edge.weight;
				if(++cnt==N-1) break;
			}
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void union(int a, int b) {
		p[findSet(b)]=p[a];
	}
	
	static int findSet(int x) {
		if(p[x]!=x) p[x]=findSet(p[x]);
		return p[x];
	}
}