import java.io.*;
import java.util.*;

public class Main {
	static int T;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Deque<Character> stack = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			stack.clear();
			String line = br.readLine();
			boolean isValid = true;
			for(char c : line.toCharArray()) {
				if(c=='(') stack.push(c);
				else {
					if(stack.isEmpty()) {
						isValid=false;
						break;
					}
					stack.pop();
				}
			}
			if(!stack.isEmpty()) isValid = false;
			sb.append(isValid ? "YES" : "NO").append('\n');
		}
		System.out.println(sb);
	}
}