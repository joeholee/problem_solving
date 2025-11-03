import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static Map<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String S = st.nextToken();
			int X = Integer.parseInt(st.nextToken());
			map.put(S, map.getOrDefault(S, 0)+X);
		}
		boolean flag = false;
		for(Map.Entry<String, Integer> e : map.entrySet()) {
			if(e.getValue()==5) {
				flag = true;
				break;
			}
		}
		bw.write(flag? "YES" : "NO");
		bw.close();
		br.close();
	}
}