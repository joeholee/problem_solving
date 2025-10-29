import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int[] H;
	static long ans;
	static Deque<int[]> st = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		H = new int[N];
		for(int i=0; i<N; i++) H[i] = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int cur = H[i];
			int idx = i;
			while(!st.isEmpty()&&cur<=st.peek()[0]) {
				ans = Math.max(ans, (long) (st.peek()[0])*(i-st.peek()[1]));
				idx = st.pop()[1];
			}
			st.push(new int[] {cur,idx});
		}
		while(!st.isEmpty()) {
			ans = Math.max(ans, (long) (st.peek()[0])*(N-st.peek()[1]));
			st.pop();
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}