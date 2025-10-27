import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static Deque<Integer> st = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		int cur = 1;
		for(int i=0; i<n; i++) {
			int val = Integer.parseInt(br.readLine());
			while(cur<=val) {
				st.push(cur++);
				sb.append("+").append('\n');
			}
			if(val!=st.peek()) {
				sb.setLength(0);
				sb.append("NO");
				break;
			}
			st.pop();
			sb.append("-").append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}