import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N,ans;
	static int[] rope;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		rope = new int[N];
		for(int i=0; i<N; i++) rope[i] = Integer.parseInt(br.readLine());
		Arrays.sort(rope);
		for(int i=0; i<N; i++) {
			ans = Math.max(ans, rope[i]*(N-i));
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}