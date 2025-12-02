import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M,ans=Integer.MAX_VALUE;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) arr[i] = Integer.parseInt(st.nextToken());
		solve();
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void solve() {
		int lo=0, hi=N;
		while(lo<=hi) {
			int mid = (lo+hi)/2;
			if(check(mid)) {
				ans=mid;
				hi=mid-1;
			} else lo=mid+1;
		}
	}
	
	static boolean check(int mid) {
		int cur=0;
		for(int i : arr) {
			int min = Math.max(0, i-mid);
			int max = Math.min(N, i+mid);
			if(min>cur) return false;
			cur = Math.max(cur, max);
			if(cur>=N) return true;
		}
		return cur>=N;
	}
}