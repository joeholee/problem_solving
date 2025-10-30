import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int K,L;
	static Set<String> s = new LinkedHashSet<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		for(int i=0; i<L; i++) {
			String num = br.readLine();
			if(s.contains(num)) s.remove(num);
			s.add(num);
		}
		int cnt=0;
		for(String str : s) {
			if(cnt++<K) sb.append(str).append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}