import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M;
	static long ans;
	static int[] A,S,mod;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N+1];
		S = new int[N+1];
		mod = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			S[i] = (S[i-1]+A[i])%M;
			mod[S[i]]++;
		}
		ans=mod[0];
		for(int i=0; i<M; i++) ans+=(long)mod[i]*(mod[i]-1)/2;
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}