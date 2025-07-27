import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static int left=1, right=0, mid, ans;
	static int[] budget;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		budget = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, budget[i]);
		}
		M = Integer.parseInt(br.readLine());
		solve();
		System.out.println(ans);
	}
	
	static void solve() {
		while(left<=right) {
			mid = (left+right)/2;
			int sum=0;
			for(int i : budget) sum+=Math.min(i, mid);
			if(sum<=M) {
				ans=mid;
				left=mid+1;
			}
			else right=mid-1;
		}
	}
}