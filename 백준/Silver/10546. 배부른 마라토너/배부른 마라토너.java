import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static Map<String, Integer> m = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<2*N-1; i++) {
			String name = br.readLine();
			m.put(name, m.getOrDefault(name, 0)+1);
		}
		for(Map.Entry<String, Integer> e : m.entrySet()) {
			if(e.getValue()%2==1) {
				sb.append(e.getKey());
				break;
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}