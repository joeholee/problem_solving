import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static String input,s,t;
	
	public static void main(String[] args) throws IOException {
		while(true) {
			input = br.readLine();
			if(input==null) break;
			st = new StringTokenizer(input);
			s = st.nextToken();
			t = st.nextToken();
			isSubsequence();
		}
		System.out.println(sb);
	}
	
	static void isSubsequence() {
		int idx=0;
		for(int i=0; i<t.length(); i++) {
			if(s.charAt(idx)==t.charAt(i)) idx++;
			if(idx==s.length()) {
				sb.append("Yes").append("\n");
				return;
			}
		}
		sb.append("No").append("\n");
	}
}