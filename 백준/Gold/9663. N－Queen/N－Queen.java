import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static int N,ans;
	static boolean[] row = new boolean[31];
	static boolean[] diag1 = new boolean[31];
	static boolean[] diag2 = new boolean[31];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		solve(0);
		System.out.println(ans);
	}
	
	static void solve(int cnt) {
		if(cnt==N) {
			ans++;
			return;
		}
		for(int i=0; i<N; i++) {
			if(row[i]||diag1[i+cnt]||diag2[cnt-i+N-1]) continue;
			row[i]=true;
			diag1[i+cnt]=true;
			diag2[cnt-i+N-1]=true;
			solve(cnt+1);
			row[i]=false;
			diag1[i+cnt]=false;
			diag2[cnt-i+N-1]=false;
		}
	}
}