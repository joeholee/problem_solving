import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
	static Stack<Integer> s;
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int N,op,data;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		s = new Stack<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			op = Integer.parseInt(st.nextToken());
			if(st.hasMoreTokens()) data = Integer.parseInt(st.nextToken());
			if(op==1) s.push(data);
			else cmd(op);
		}
		System.out.print(sb);
	}
	
	static void cmd(int op) {
		switch(op) {
			case 2:
				if(!s.isEmpty()) sb.append(s.pop()).append("\n");
				else sb.append(-1).append("\n");
				break;
			case 3:
				sb.append(s.size()).append("\n");
				break;
			case 4:
				if(s.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case 5:
				if(!s.isEmpty()) sb.append(s.peek()).append("\n");
				else sb.append(-1).append("\n");
		}
	}
}