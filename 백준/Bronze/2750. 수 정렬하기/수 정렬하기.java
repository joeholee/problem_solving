import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.TreeSet;

public class Main {
	static int N,tmp;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static TreeSet<Integer> set = new TreeSet<>();

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		while(N>0) {
			tmp = Integer.parseInt(br.readLine());
			set.add(tmp);
			N--;
		}
		while(!set.isEmpty()) {
			sb.append(set.first()).append("\n");
			set.pollFirst();
		}
		System.out.println(sb);
	}
}