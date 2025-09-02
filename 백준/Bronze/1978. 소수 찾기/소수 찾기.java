import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,cnt;
	static boolean isPrime[];
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		isPrime = new boolean[1001];
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		for(int i=2; i*i<=1000; i++) {
			if(!isPrime[i]) continue;
			for(int j=i*i; j<=1000; j+=i) isPrime[j] = false;
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) if(isPrime[Integer.parseInt(st.nextToken())]) cnt++;
		bw.write(cnt+"");
		bw.close();
		br.close();
	}
}