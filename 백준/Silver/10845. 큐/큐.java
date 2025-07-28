import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static Deque<Integer> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push":
				int val = Integer.parseInt(st.nextToken());
				q.offer(val);
				break;
			case "pop":
				sb.append(q.isEmpty() ? -1 : q.poll()).append('\n');
				break;
			case "size":
				sb.append(q.size()).append('\n');
				break;
			case "empty":
				sb.append(q.isEmpty() ? 1 : 0).append('\n');
				break;
			case "front":
				sb.append(q.isEmpty() ? -1 : q.peek()).append('\n');
				break;
			case "back":
				sb.append(q.isEmpty() ? -1 : q.peekLast()).append('\n');
				break;
			}
		}
		System.out.println(sb);
	}
}