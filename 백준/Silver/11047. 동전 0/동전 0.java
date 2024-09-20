import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,K,ans;
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N];
		for(int i=0; i<N; i++) A[i]=Integer.parseInt(br.readLine());
		solve();
		System.out.println(ans);
	}
	
	static void solve() {
		for(int i=N-1; i>=0; i--) {
			if(K==0) break;
			if(A[i]>K) continue;
			ans+=K/A[i];
			K%=A[i];
		}
	}
}