import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M,l,r;
	static int min = Integer.MAX_VALUE;
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N];
		for(int i=0; i<N; i++) A[i]=Integer.parseInt(br.readLine());
		Arrays.sort(A);
		for(int l=0; l<N; l++) {
			while(r<N && A[r]-A[l]<M) r++;
			if(r==N) break;
			min = Math.min(min, A[r]-A[l]);
		}
		bw.write(min+"");
		bw.close();
		br.close();
	}
}