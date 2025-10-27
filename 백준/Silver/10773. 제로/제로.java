import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int K,ans;
	static Deque<Integer> st = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		K = Integer.parseInt(br.readLine());
		while(K-->0) {
			int cur = Integer.parseInt(br.readLine());
			if(cur==0) st.pop();
			else st.push(cur);
		}
		while(!st.isEmpty()) ans+=st.pop();
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}