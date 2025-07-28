import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static Set<String> hear = new HashSet<>();
	static TreeSet<String> hearSee = new TreeSet<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		hear = new HashSet<>(N);
		for(int i=0; i<N; i++) hear.add(br.readLine());
		for(int i=0; i<M; i++) {
			String name = br.readLine();
			if(hear.contains(name)) hearSee.add(name);
		}
		sb.append(hearSee.size()).append('\n');
		for(String s : hearSee) sb.append(s).append('\n');
		System.out.println(sb);
	}
}