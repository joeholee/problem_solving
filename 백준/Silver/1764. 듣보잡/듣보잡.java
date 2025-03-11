import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		HashSet<String> hs = new HashSet<>();
		TreeSet<String> ts = new TreeSet<>();
		for(int i=0; i<N; i++) hs.add(br.readLine());
		for(int i=0; i<M; i++) {
			String input = br.readLine();
			if(hs.contains(input)) ts.add(input);
		}
		sb.append(ts.size()).append("\n");
		while(!ts.isEmpty()) {
			sb.append(ts.pollFirst()).append("\n");
		}
		System.out.println(sb);
	}
}