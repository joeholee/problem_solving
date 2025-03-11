import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N,M;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		HashSet<Integer> set = new HashSet<>(N);
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) set.add(Integer.parseInt(st.nextToken()));
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			if(set.contains(Integer.parseInt(st.nextToken()))) sb.append("1");
			else sb.append("0");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}