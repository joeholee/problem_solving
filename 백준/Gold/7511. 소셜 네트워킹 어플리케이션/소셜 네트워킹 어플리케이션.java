import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T,n,k,m;
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("Scenario ").append(t).append(":").append('\n');
			n = Integer.parseInt(br.readLine());
			p = new int[n+1];
			for(int i=0; i<=n; i++) p[i] = i;
			k = Integer.parseInt(br.readLine());
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			m = Integer.parseInt(br.readLine());
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				sb.append(findSet(u)==findSet(v) ? 1 : 0).append('\n');
			}
			sb.append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static int findSet(int x) {
		if(p[x]!=x) p[x] = findSet(p[x]);
		return p[x];
	}
	
	static void union(int a, int b) {
		p[findSet(b)] = findSet(a);
	}
}