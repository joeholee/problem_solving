import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] L;
	static int[][] ans; // cnt idx
	static Deque<int[]> stack = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		L = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) L[i] = Integer.parseInt(st.nextToken());
		ans = new int[N][2];
		for(int[] r : ans) r[1]=100001;
		for(int i=0; i<N; i++) {
			int cur = L[i];
			while(!stack.isEmpty()&&cur>=stack.peek()[0]) stack.pop();
			ans[i][0]+=stack.size();
			if(!stack.isEmpty()) ans[i][1] = stack.peek()[1];
			stack.push(new int[] {cur,i+1});
		}
		stack.clear();
		for(int i=N-1; i>=0; i--) {
			int cur = L[i];
			while(!stack.isEmpty()&&cur>=stack.peek()[0]) stack.pop();
			ans[i][0]+=stack.size();
			if(!stack.isEmpty()) {
				if(ans[i][1]!=100001) {
					int dist = Math.abs(i-(ans[i][1]-1));
					if(stack.peek()[1]-1-i<dist) ans[i][1] = stack.peek()[1]; 
				} else ans[i][1] = stack.peek()[1];
			}
			stack.push(new int[] {cur,i+1});
		}
		for(int i=0; i<N; i++) {
			sb.append(ans[i][0]);
			if(ans[i][1]!=100001) sb.append(' ').append(ans[i][1]);
			sb.append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}