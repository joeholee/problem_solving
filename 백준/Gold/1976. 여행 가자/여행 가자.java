import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int[] p, plan;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		p = new int[N+1]; // 1번부터 시작
		plan = new int[M];
		for(int i=1; i<=N; i++) p[i]=i; // makeSet
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				if(Integer.parseInt(st.nextToken())==1)
					union(i,j);
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) plan[i]=Integer.parseInt(st.nextToken());
		boolean possible = true;
		int root = findSet(plan[0]);
		for(int i=1; i<M; i++) {
			if(findSet(plan[i])!=root) {
				possible=false;
				break;
			}
		}
		System.out.println(possible ? "YES" : "NO");
	}
	
	static int findSet(int x) {
		if(p[x] != x) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}
	
	static void union(int a, int b) {
		p[findSet(b)] = findSet(a);
	}
}
