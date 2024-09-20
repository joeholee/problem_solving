import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M,ans;
	static int[][] users,kevin;
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		users = new int[N+1][N+1];
		kevin = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			users[A][B]=users[B][A]=1;
		}
		solve();
		System.out.println(ans);
	}
	
	static void solve() {
		// init
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) kevin[i][j]=0;
				else if(users[i][j]==1) kevin[i][j]=1;
				else kevin[i][j]=INF;
			}
		}
		// floyd
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					kevin[i][j]=Math.min(kevin[i][j], kevin[i][k]+kevin[k][j]);
				}
			}
		}
		// min
		int min=INF;
		for(int i=1; i<=N; i++) {
			int tmp=0;
			for(int j=1; j<=N; j++) {
				tmp+=kevin[i][j];
			}
			if(tmp<min) {
				min=tmp;
				ans=i;
			}
		}
	}
}