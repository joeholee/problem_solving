import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n,ans;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) sb.append('*');
			sb.append('\n');
		}
		System.out.println(sb);
	}
}