import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] W;
	static boolean[] vis;
	static int ans=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		vis = new boolean[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) W[i][j]=Integer.parseInt(st.nextToken());
		}
		vis[0]=true;
		dfs(0,0,0,1);
		System.out.println(ans);
	}
	
	static void dfs(int cur, int cost, int start, int cnt) {
		if(cnt==N) {
			if(W[cur][start]!=0) {
				ans=Math.min(ans, cost+W[cur][start]);
			}
			return;
		}
		for(int i=0; i<N; i++) {
			if(!vis[i] && W[cur][i]!=0) {
				vis[i]=true;
				dfs(i,cost+W[cur][i],start,cnt+1);
				vis[i]=false;
			}
		}
	}
}