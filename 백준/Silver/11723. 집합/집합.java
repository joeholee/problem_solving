import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int M,x;
	static Set<Integer> s = new HashSet<>();
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String inst = st.nextToken();
			if(st.hasMoreTokens()) x = Integer.parseInt(st.nextToken());
			switch(inst) {
			case "add":
				s.add(x);
				break;
			case "remove":
				s.remove(x);
				break;
			case "check":
				sb.append(s.contains(x) ? 1 : 0).append('\n');
				break;
			case "toggle":
				if(s.contains(x)) s.remove(x);
				else s.add(x);
				break;
			case "all":
				for(int j=1; j<=20; j++) s.add(j);
				break;
			case "empty":
				s.clear();
				break;
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}