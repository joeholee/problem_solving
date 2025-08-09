import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[] fac;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		fac = new int[N+1];
		fac[0] = 1;
		if(N>=1) fac[1] = 1;
		if(N>=2) {
			for(int i=2; i<=N; i++) fac[i] = i*fac[i-1];
		}
		System.out.println(fac[N]);
	}
}