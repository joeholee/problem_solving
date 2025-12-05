import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static long ans;
	static int[] A;
	static Set<Integer> s = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		int st=0, en=0;
		while(true) {
			while(en<N&&!s.contains(A[en])) s.add(A[en++]);
			ans+=(en-st);
			if(st==N-1) break;
			s.remove(A[st++]);
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}