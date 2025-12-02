import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T,N,M,ans;
	static int[] A,B;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			A = new int[N];
			B = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) B[i] = Integer.parseInt(st.nextToken());
			ans=0;
			Arrays.sort(B);
			solve();
			sb.append(ans).append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void solve() {
		for(int i : A) {
			int lo=0, hi=M-1;
			int cnt=0;
			while(lo<=hi) {
				int mid = (lo+hi)/2;
				if(i>B[mid]) {
					cnt=mid+1;
					lo=mid+1;
				} else hi=mid-1;
			}
			ans+=cnt;
		}
	}
}