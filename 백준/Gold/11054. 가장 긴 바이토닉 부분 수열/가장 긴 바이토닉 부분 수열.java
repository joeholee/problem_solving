import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,ans;
	static int[] A,dpi,dpd,lis;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		dpi = new int[N];
		Arrays.fill(dpi, 1);
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(A[i]>A[j]) dpi[i] = Math.max(dpi[i], dpi[j]+1);
			}
		}
		dpd = new int[N];
		Arrays.fill(dpd, 1);
		for(int i=N-1; i>=0; i--) {
			for(int j=N-1; j>i; j--) {
				if(A[i]>A[j]) dpd[i] = Math.max(dpd[i], dpd[j]+1);
			}
		}
		lis = new int[N];
		for(int i=0; i<N; i++) {
			lis[i] = dpi[i]+dpd[i]-1;
			ans = Math.max(ans, lis[i]);
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}