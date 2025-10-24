import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int n;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		sb.append(fib(n)).append(' ').append(fibonacci(n));
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static int fib(int n) {
		int[] f = new int[n+1];
		f[1]=1; f[2]=1;
		for(int i=3; i<=n; i++) f[i]=f[i-1]+f[i-2];
		return f[n];
	}
	
	static int fibonacci(int n) {
		return n-2;
	}
}