import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static Deque<int[]> stack = new ArrayDeque<>();
	static int N;
	static int[] towers;
	static int[] ans;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		towers = new int[N];
		ans = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) towers[i] = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			int cur = towers[i];
			while(!stack.isEmpty()&&stack.peek()[1]<cur) stack.pop();
			if(!stack.isEmpty()) ans[i] = stack.peek()[0];
			stack.push(new int[] {i+1,cur});
		}
		for(int i : ans) sb.append(i).append(' ');
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}