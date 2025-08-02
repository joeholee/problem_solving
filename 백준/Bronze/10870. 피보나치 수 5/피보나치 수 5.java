import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[] fib;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		fib = new int[n+1];
		if(n>=1) {
			fib[1]=1;
			for(int i=2; i<=n; i++) fib[i]=fib[i-2]+fib[i-1];
		}
		System.out.println(fib[n]);
	}
}