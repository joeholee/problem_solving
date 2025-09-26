import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) sb.append(binarySearch(0,N-1,Integer.parseInt(st.nextToken()))).append('\n');
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static int binarySearch(int left, int right, int val) {
		while(left<=right) {
			int mid = (left+right)/2;
			if(A[mid]==val) return 1;
			else if(A[mid]<val) left = mid+1;
			else right = mid-1;
		}
		return 0;
	}
}