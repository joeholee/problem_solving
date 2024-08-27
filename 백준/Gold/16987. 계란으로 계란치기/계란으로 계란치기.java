import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static int N,tmp,ans;
	static int[] S,W;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		W = new int[N];
		for(int i=0; i<N; i++) {
			String[] data = br.readLine().split(" ");
			S[i]=Integer.parseInt(data[0]);
			W[i]=Integer.parseInt(data[1]);
		}
		solve(0,0);
		System.out.println(ans);
	}
	
	static void solve(int idx, int cnt) {
		if(idx==N) {
			ans=Math.max(ans,cnt);
			return;
		}
		if(S[idx]<=0 || cnt==N-1) {
			solve(idx+1,cnt);
			return;
		}
		tmp=cnt;
		for(int i=0; i<N; i++) {
			if(i==idx || S[i]<=0) continue;
			S[i]-=W[idx];
			S[idx]-=W[i];
			if(S[i]<=0) tmp++;
			if(S[idx]<=0) tmp++;
			solve(idx+1,tmp);
			S[i]+=W[idx];
			S[idx]+=W[i];
			tmp=cnt;
		}
	}
}