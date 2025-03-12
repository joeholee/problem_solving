import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		HashSet<Integer> hs = new HashSet<>();
		for(int i=0; i<N; i++) hs.add(Integer.parseInt(st.nextToken()));
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) sb.append(hs.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append(" ");
		System.out.println(sb);
	}
}