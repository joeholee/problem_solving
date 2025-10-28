import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] A,ans;
	static Deque<Integer> stack = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		ans = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		Arrays.fill(ans, -1);
		for(int i=N-1; i>=0; i--) {
			int cur = A[i];
			while(!stack.isEmpty()&&cur>=stack.peek()) stack.pop();
			if(!stack.isEmpty()) ans[i] = stack.peek();
			stack.push(cur);
		}
		for(int i : ans) sb.append(i).append(' ');
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}