import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,ans;
	static char[] K;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		K = br.readLine().toCharArray();
		for(char c : K) if(c=='1') ans++;
		System.out.println(ans);
	}
}