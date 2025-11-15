import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static long X;
	static long[] len,patty;
 	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Long.parseLong(st.nextToken());
		len = new long[N+1];
		len[0]=1L;
		for(int i=1; i<=N; i++) len[i]=len[i-1]*2+3;
		patty = new long[N+1];
		patty[0]=1L;
		for(int i=1; i<=N; i++) patty[i]=patty[i-1]*2+1;
		bw.write(func(N,X)+"");
		bw.close();
		br.close();
	}
	
	static long func(int N, long X) {
		if(N==0) return 1L;
		if(X<=1) return 0;
		long mid = len[N-1]+2;
		if(X==len[N]) return patty[N];
		if(X==mid) return patty[N-1]+1;
		if(X>0&&X<mid) return func(N-1,X-1);
		if(X>mid&&X<len[N]) return patty[N-1]+1+func(N-1,X-mid);
		return -1;
	}
}