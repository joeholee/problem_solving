import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		System.out.println(solve(N));
	}
	
	static int solve(int N) {
		if(N==1) return 2;
		else return 2*solve(N-1);
	}
}