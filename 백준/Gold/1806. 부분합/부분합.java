import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,S,l,r,sum;
	static int[] A;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) A[i]=Integer.parseInt(st.nextToken());
		sum = A[0];
		for(int l=0; l<N; l++) {
			while(r<N && sum<S) {
				r++;
				if(r!=N) sum+=A[r];
			}
			if(r==N) break;
			min = Math.min(min, r-l+1);
			sum-=A[l];
		}
		if(min==Integer.MAX_VALUE) min=0; 
		bw.write(min+"");
		bw.close();
		br.close();
	}
}