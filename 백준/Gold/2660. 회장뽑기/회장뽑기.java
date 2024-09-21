import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] members;
	static int[] res;
	static List<Integer> candidates = new ArrayList<>();
	static int N;
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		members = new int[N+1][N+1];
		res = new int[N+1];
		// init
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) members[i][j]=0;
				else members[i][j]=INF;
			}
		}
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==-1) break;
			members[a][b]=members[b][a]=1;
		}
		// floyd
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					members[i][j]=Math.min(members[i][j], members[i][k]+members[k][j]);
				}
			}
		}
		solve();
		System.out.println(sb);
	}
	
	static void solve() {
		int min=INF;
		for(int i=1; i<=N; i++) {
			int max=0;
			for(int j=1; j<=N; j++) {
				if(i!=j) max=Math.max(max, members[i][j]);
			}
			res[i]=max;
			min=Math.min(min,res[i]);
		}
		for(int i=1; i<=N; i++) {
			if(res[i]==min) candidates.add(i);
		}
		sb.append(min).append(" ").append(candidates.size()).append("\n");
		for(int candidate : candidates) sb.append(candidate).append(" ");
	}
}