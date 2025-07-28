import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static Deque<Integer> stack = new ArrayDeque<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		while(N-->0) {
			String line = br.readLine();
			st = new StringTokenizer(line);
			switch(st.nextToken()) {
				case "push" :
					int val = Integer.parseInt(st.nextToken());
					stack.push(val);
					break;
				case "pop":
					sb.append(stack.isEmpty() ? -1 : stack.pop()).append('\n');
					break;
				case "size":
					sb.append(stack.size()).append('\n');
					break;
				case "empty":
					sb.append(stack.isEmpty() ? 1 : 0).append('\n');
					break;
				case "top":
					sb.append(stack.isEmpty() ? -1 : stack.peek()).append('\n');
					break;
			}
		}
		System.out.println(sb);
	}
}