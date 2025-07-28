import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static Set<String> s = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		s.add("ChongChong");
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String name1 = st.nextToken();
			String name2 = st.nextToken();
			if(s.contains(name1)||s.contains(name2)) {
				s.add(name1);
				s.add(name2);
			}
		}
		System.out.println(s.size());
	}
}