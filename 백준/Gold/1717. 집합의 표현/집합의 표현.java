import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n,m;
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		p = new int[n+1];
		for(int i=0; i<=n; i++) p[i] = i;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(q==0) union(a,b);
			else sb.append(findSet(a)==findSet(b) ? "YES" : "NO").append('\n');
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