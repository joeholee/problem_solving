import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M,diff,ans=Integer.MAX_VALUE;
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N];
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(br.readLine());
		Arrays.sort(A);
		int st=0,en=0;
		while(st<=en&&en<A.length) {
			diff = A[en]-A[st];
			if(diff>=M) {
				ans = Math.min(ans, diff);
				st++;
			} else en++;
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}