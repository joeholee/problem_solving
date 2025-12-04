import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static int[] A,B;
	static Set<Integer> s = new TreeSet<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N];
		B = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) B[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(B);
		for(int i : A) {
			if(Arrays.binarySearch(B, i)<0) s.add(i);
		}
		sb.append(s.size());
		if(s.size()>0) {
			sb.append('\n');
			for(int i : s) sb.append(i).append(' ');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}