import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static long ans;
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A);
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				int lo = lower(j+1, N-1, (A[i]+A[j])*-1);
				int hi = upper(j+1, N-1, (A[i]+A[j])*-1);
				ans+=(hi-lo);
			}
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static int lower(int start, int end, int val) {
		while(start<=end) {
			int mid = (start+end)/2;
			if(A[mid]>=val) end=mid-1;
			else start=mid+1;
		}
		return start;
	}
	
	static int upper(int start, int end, int val) {
		while(start<=end) {
			int mid = (start+end)/2;
			if(A[mid]>val) end=mid-1;
			else start=mid+1;
		}
		return start;
	}
}