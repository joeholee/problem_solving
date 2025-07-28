import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int K,sum;
	static Deque<Integer> stack = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		K = Integer.parseInt(br.readLine());
		while(K-->0) {
			int val = Integer.parseInt(br.readLine());
			if(val==0) stack.pop();
			else stack.push(val);
		}
		while(!stack.isEmpty()) sum+=stack.pop();
		System.out.println(sum);
	}
}