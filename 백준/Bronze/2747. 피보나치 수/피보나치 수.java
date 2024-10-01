import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long[] fib;
	static int n;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		fib = new long[n+1];
		fib[0]=0;
		fib[1]=1;
		if(n>=2) {
			for(int i=2; i<=n; i++) fib[i]=fib[i-2]+fib[i-1];
		}
		System.out.println(fib[n]);
	}
}