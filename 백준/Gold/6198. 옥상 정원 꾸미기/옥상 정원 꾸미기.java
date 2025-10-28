import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static long ans;
	static int[] h;
	static Deque<Integer> st = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		h = new int[N];
		for(int i=0; i<N; i++) h[i] = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int cur = h[i];
			while(!st.isEmpty()&&cur>=st.peek()) st.pop();
			ans+=st.size();
			st.push(cur);
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}