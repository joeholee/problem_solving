import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M;
	static int[] T;
	static long ans=Long.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = new int[N];
		for(int i=0; i<N; i++) T[i] = Integer.parseInt(br.readLine());
		Arrays.sort(T);
		long left=(long) T[0], right=(long) M*T[N-1];
		while(left<=right) {
			long mid = (left+right)/2;
			long sum=0;
			for(int i : T) {
				sum+=mid/i;
				if(sum>=M) break;
			}
			if(sum>=M) {
				right=mid-1;
				ans = Math.min(ans, mid);
			} else left=mid+1;
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}