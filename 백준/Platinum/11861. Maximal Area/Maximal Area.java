import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int[] D;
	static long ans;
	static Deque<int[]> stack = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		D = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) D[i] = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			int cur = D[i];
			int idx = i;
			while(!stack.isEmpty()&&cur<=stack.peek()[0]) {
				ans = Math.max(ans, (long) (stack.peek()[0])*(i-stack.peek()[1]));
				idx = stack.pop()[1];
			}
			stack.push(new int[] {cur,idx});
		}
		while(!stack.isEmpty()) {
			ans = Math.max(ans, (long) (stack.peek()[0])*(N-stack.peek()[1]));
			stack.pop();
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}