import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M,cnt,ans;
	static int[] p;
	static List<Integer> truth;
	static List<Integer>[] party;
	
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N+1]; // 1~N
		for(int i=1; i<=N; i++) p[i]=i; // makeSet
		st = new StringTokenizer(br.readLine());
		cnt = Integer.parseInt(st.nextToken());
		if(cnt==0) {
			System.out.println(M);
			return;
		}
		// truth
		truth = new ArrayList<>();
		for(int i=0; i<cnt; i++) truth.add(Integer.parseInt(st.nextToken()));
		// parties
		party = new ArrayList[M];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			party[i] = new ArrayList<>();
			int p_size = Integer.parseInt(st.nextToken());
			for(int j=0; j<p_size; j++) party[i].add(Integer.parseInt(st.nextToken()));
			// same party => union
			for(int j=1; j<p_size; j++) {
				unionSet(party[i].get(0),party[i].get(j));
			}
		}
		// know truth => union
		for(int i=1; i<cnt; i++) unionSet(truth.get(0),truth.get(i));
		for(int i=0; i<M; i++) {
			boolean canLie=true;
			for(int n : party[i]) {
				if(findSet(n)==findSet(truth.get(0))) {
					canLie=false;
					break;
				}
			}
			if(canLie) ans++;
		}
		System.out.println(ans);
	}
	
	static int findSet(int x) {
		if(p[x]!=x) p[x]=findSet(p[x]);
		return p[x];
	}
	
	static void unionSet(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
}