import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static Deque<Integer> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) q.offer(i+1);
		while(!q.isEmpty()) {
			sb.append(q.poll()).append(' ');
			if(!q.isEmpty()) q.offer(q.poll());
		}
		System.out.println(sb);
	}
}