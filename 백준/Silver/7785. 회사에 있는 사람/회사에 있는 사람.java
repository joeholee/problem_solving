import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n;
	static Map<String,Integer> emp = new TreeMap<>(Collections.reverseOrder());
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String status = st.nextToken();
			switch(status) {
			case "enter":
				emp.put(name, emp.getOrDefault(name, 0)+1);
				break;
			case "leave":
				emp.put(name, emp.getOrDefault(name, 0)-1);
				break;
			}
		}
		for(Map.Entry<String,Integer> e : emp.entrySet()) {
			if(e.getValue()>0) sb.append(e.getKey()).append('\n');
		}
		System.out.println(sb);
	}
}