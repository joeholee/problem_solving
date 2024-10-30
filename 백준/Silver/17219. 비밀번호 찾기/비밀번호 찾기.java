import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static HashMap<String, String> h = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String pw = st.nextToken();
			h.put(site, pw);
		}
		for(int i=0; i<M; i++) {
			sb.append(h.get(br.readLine())).append("\n");
		}
		System.out.println(sb);
	}
}