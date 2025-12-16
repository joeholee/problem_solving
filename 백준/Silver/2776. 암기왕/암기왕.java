import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T,N,M;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			Map<Integer, Integer> m = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) m.put(Integer.parseInt(st.nextToken()), 1);
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) sb.append(m.getOrDefault(Integer.parseInt(st.nextToken()), 0)).append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}