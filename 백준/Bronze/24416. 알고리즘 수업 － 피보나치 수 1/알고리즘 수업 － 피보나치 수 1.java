import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int n,cnt;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		fib(n);
		sb.append(cnt).append(' ');
		cnt=0;
		fibonacci(n);
		sb.append(cnt);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static int fib(int n) {
		if(n==1||n==2) {
			cnt++;
			return 1;
		}
		else return fib(n-1)+fib(n-2);		
	}
	
	static int fibonacci(int n) {
		int[] f = new int[n+1];
		f[1]=1; f[2]=1;
		for(int i=3; i<=n; i++) {
			cnt++;
			f[i]=f[i-1]+f[i-2];
		}
		return f[n];
	}
}