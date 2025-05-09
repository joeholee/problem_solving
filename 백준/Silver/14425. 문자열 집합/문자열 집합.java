import java.io.*;
import java.util.*;

public class Main {
	static int N,M,ans;
	static Set<String> s;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		s = new HashSet<>(N);
		for(int i=0; i<N; i++) s.add(br.readLine());
		while(M-->0) {
			if(s.contains(br.readLine())) ans++;
		}
		System.out.println(ans);
	}
}