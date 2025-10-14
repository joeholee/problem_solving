import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int A,B;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		sb.append(gcd(A,B)).append('\n').append(lcm(A,B));
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static int gcd(int A, int B) {
		if(B==0) return A;
		return gcd(B,A%B);
	}
	
	static int lcm(int A, int B) {
		return(A*B)/gcd(A,B);
	}
}