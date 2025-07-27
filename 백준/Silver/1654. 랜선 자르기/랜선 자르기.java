import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int K,N;
	static int[] lan;
	static long left=1,right=0, mid, ans;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		lan = new int[K];
		for(int i=0; i<K; i++) {
			lan[i] = Integer.parseInt(br.readLine());
			right = Math.max(right, lan[i]);
		}
		solve();
		System.out.println(ans);
	}
	
	static void solve() {
		while(left<=right) {
			mid = (left+right)/2;
			long cnt=0;
			for(int i : lan) cnt+=(i/mid);
			if(cnt<N) right=mid-1;
			else {
				ans=mid;
				left=mid+1;
			}
		}
	}
}