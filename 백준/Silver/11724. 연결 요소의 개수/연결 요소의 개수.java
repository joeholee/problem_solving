import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int[] p;
	static Set<Integer> s = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		for(int i=1; i<=N; i++) p[i]=i; // makeSet
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if(findSet(u)!=findSet(v)) unionSet(u,v);
		}
		for(int i=1; i<=N; i++) s.add(findSet(i));
		System.out.println(s.size());
	}
	
	static int findSet(int x) {
		if(p[x]!=x) p[x]=findSet(p[x]);
		return p[x];
	}
	
	static void unionSet(int a, int b) {
		p[findSet(b)] = findSet(a);
	}
}