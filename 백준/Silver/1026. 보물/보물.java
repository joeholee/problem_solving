import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int[] A,B;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) B[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A);
		Arrays.sort(B);
		int sum=0;
		for(int i=0; i<N; i++) sum+=A[N-1-i]*B[i];
		bw.write(sum+"");
		bw.close();
		br.close();
	}
}