import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Stack<Character> st = new Stack<>();
	static char[] S;
	static boolean isTag;
	
	public static void main(String[] args) throws IOException {
		S = br.readLine().toCharArray();
		for(int i=0; i<S.length; i++) {
			if(S[i]=='<') {
				while(!st.isEmpty()) {
					char popItem = st.pop();
					sb.append(popItem);
				}
				isTag=true;
				sb.append(S[i]);
				continue;
			}
			if(S[i]=='>') {
				isTag=false;
				sb.append(S[i]);
				continue;
			}
			if(S[i]==' ') {
				while(!st.isEmpty()) {
					char popItem = st.pop();
					sb.append(popItem);
				}
				sb.append(S[i]);
				continue;
			}
			if(isTag) sb.append(S[i]);
			else st.add(S[i]);
		}
		while(!st.isEmpty()) {
			char popItem = st.pop();
			sb.append(popItem);
		}
		System.out.println(sb);
	}
}