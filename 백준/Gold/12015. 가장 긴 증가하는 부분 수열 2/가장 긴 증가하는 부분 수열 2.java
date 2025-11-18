import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,ans;
	static int[] A,lis;
 	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		lis = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		lis[0] = A[0];
		for(int i=1; i<N; i++) {
			int val = A[i];
			if(val>lis[ans]) {
				ans++;
				lis[ans]=val;
			} else {
				int lo=0, hi=ans;
				while(lo<hi) {
					int mid = (lo+hi)/2;
					if(lis[mid]<val) lo=mid+1;
					else hi=mid;
				}
				lis[lo]=val;
			}
		}
		bw.write(ans+1+"");
		bw.close();
		br.close();
	}
}