import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int T,N;
	static long[] P;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			P = new long[N+1];
			P[1] = 1;
			if(N>=2) P[2] = 1;
			if(N>=3) {
				for(int i=3; i<=N; i++) P[i] = P[i-3]+P[i-2];
			}
			sb.append(P[N]).append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}