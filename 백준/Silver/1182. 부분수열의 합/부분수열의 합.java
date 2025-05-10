import java.io.*;
import java.util.*;

public class Main {
	static int N,S,ans;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i]=Integer.parseInt(st.nextToken());
		solve(0,0);
		if(S==0) ans--;
		System.out.println(ans);
	}
	
	static void solve(int cnt, int sum) {
		if(cnt==N) {
			if(sum==S) ans++;
			return;
		}
		solve(cnt+1, sum+arr[cnt]);
		solve(cnt+1, sum);
	}
}