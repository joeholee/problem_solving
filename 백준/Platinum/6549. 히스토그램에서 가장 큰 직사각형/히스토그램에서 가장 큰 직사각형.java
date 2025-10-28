import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long ans;
	static int n;
	static int[] h;
	static Deque<int[]> stack = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		while(true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n==0) break;
			ans = 0;
			stack.clear();
			h = new int[n];
			for(int i=0; i<n; i++) h[i] = Integer.parseInt(st.nextToken());
			for(int i=0; i<n; i++) {
				int cur = h[i];
				int idx = i;
				while(!stack.isEmpty()&&cur<=stack.peek()[0]) {
					ans = Math.max(ans, (long) (i-stack.peek()[1])*stack.peek()[0]);
					idx = stack.peek()[1];
					stack.pop();
				}
				stack.push(new int[] {cur,idx});
			}
			while(!stack.isEmpty()) {
				ans = Math.max(ans, (long) (n-stack.peek()[1])*stack.peek()[0]);
				stack.pop();
			}
			sb.append(ans).append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}