import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,ans;
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A);
		for(int i=0; i<N; i++) solve(i);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void solve(int i) {
		for(int j=0; j<N; j++) {
			if(i==j) continue;
			int val = A[i]-A[j];
			int idx = lower(A,val);
			while(idx<N&&A[idx]==val) {
				if(idx!=i&&idx!=j) {
					ans++;
					return;
				}
				idx++;
			}
		}
	}
	
	static int lower(int[] arr, int val) {
		int lo=0, hi=arr.length-1;
		int pos=arr.length;
		while(lo<=hi) {
			int mid = (lo+hi)/2;
			if(A[mid]>=val) {
				pos=mid;
				hi=mid-1;
			}
			else lo=mid+1;
		}
		return pos;
	}
}