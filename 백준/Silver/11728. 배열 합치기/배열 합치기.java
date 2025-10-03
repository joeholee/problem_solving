import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static int[] A,B,C;
	
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
		C = new int[N+M];
		int a=0,b=0;
		for(int i=0; i<N+M; i++) {
			if(a==N) C[i]=B[b++];
			else if(b==M) C[i]=A[a++];
			else {
				if(A[a]<=B[b]) C[i]=A[a++];
				else C[i]=B[b++];
			}
		}
		for(int i : C) sb.append(i).append(' ');
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}