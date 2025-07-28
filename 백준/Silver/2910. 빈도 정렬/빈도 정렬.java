import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,C;
	static Map<Integer,Integer> m = new LinkedHashMap<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int key = Integer.parseInt(st.nextToken());
			m.put(key, m.getOrDefault(key, 0)+1);
		}
		List<Integer> li = new ArrayList<>(m.keySet());
		Collections.sort(li, (o1, o2) -> m.get(o2)-m.get(o1));
		for(int l : li) {
			for(int i=0; i<m.get(l); i++) sb.append(l).append(' ');
		}
		System.out.println(sb);
	}
}