import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		String input = br.readLine();
		ArrayDeque<Character> st = new ArrayDeque<>();
		for(char c : input.toCharArray()) {
			if('A'<=c && c<='Z') sb.append(c);
			else if(c=='(') st.push(c);
			else if(c==')') {
				while(!st.isEmpty() && st.peek()!='(') {
					sb.append(st.pop());
				}
				if(!st.isEmpty()) st.pop();
			}
			else if(c=='*' || c=='/') {
				while(!st.isEmpty() && (st.peek()=='*'||st.peek()=='/')) {
					sb.append(st.pop());
				}
				st.push(c);
			}
			else if(c=='+' || c=='-') {
				while(!st.isEmpty() && st.peek()!='(') sb.append(st.pop());
				st.push(c);
			}
		}
		while(!st.isEmpty()) sb.append(st.pop());
		System.out.println(sb);
	}
}