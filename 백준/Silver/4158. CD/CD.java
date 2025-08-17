import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M,ans;
	static Set<Integer> s;
	
	public static void main(String[] args) throws IOException {
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N==0 && M==0) break;
			ans=0;
			s = new HashSet<>(N);
			for(int i=0; i<N; i++) s.add(Integer.parseInt(br.readLine()));
			for(int i=0; i<M; i++) {
				int num = Integer.parseInt(br.readLine());
				if(s.contains(num)) ans++;
			}
			sb.append(ans).append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}