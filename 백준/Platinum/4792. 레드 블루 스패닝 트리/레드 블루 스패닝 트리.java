import java.io.*;
import java.util.*;

public class Main {
	static class Edge {
		char color;
		int from,to;
		
		Edge(char c, int from, int to) {
			this.color=c;
			this.from=from;
			this.to=to;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n,m,k,cnt,blue,minBlue,maxBlue;
	static int[] p;
	static List<Edge> adj;
	
	public static void main(String[] args) throws IOException {
		while(true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			if(n==0 && m==0 && k==0) break;
			adj = new ArrayList<>();
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				char c = st.nextToken().charAt(0);
				int f = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				adj.add(new Edge(c,f,t));
			}
			minBlue = kruskal(false);
			maxBlue = kruskal(true);
			sb.append(minBlue<=k && k<=maxBlue ? 1 : 0).append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static int kruskal(boolean isBlue) {
		p = new int[n+1];
		for(int i=1; i<=n; i++) p[i]=i;
		
		adj.sort((a,b)->{
			if(a.color==b.color) return 0;
			return (isBlue ? a.color=='B' : a.color=='R') ? -1 : 1;
		});
		cnt=0;
		int blue=0;
		for(Edge e : adj) {
			if(findSet(e.from)!=findSet(e.to)) {
				union(e.from,e.to);
				cnt++;
				if(e.color=='B') blue++;
			}
			if(cnt==n-1) break;
		}
		return blue;
	}
	
	static void union(int a, int b) {
		p[findSet(b)]=p[a];
	}
	
	static int findSet(int x) {
		if(p[x]!=x) p[x]=findSet(p[x]);
		return p[x];
	}
}