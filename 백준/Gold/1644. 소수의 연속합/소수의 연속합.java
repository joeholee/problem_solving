import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N,sum,ans;
	static boolean[] isPrime;
	static List<Integer> prime = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		if(N<2) {
			bw.write(0+"");
			bw.close();
			br.close();
			return;
		}
		isPrime = new boolean[N+1];
		Arrays.fill(isPrime, true);
		isPrime[0]=false; isPrime[1]=false;
		for(int i=2; (long)i*i<=N; i++) {
			if(!isPrime[i]) continue;
			for(long j=(long)i*i; j<=N; j+=i) isPrime[(int) j] = false;
		}
		for(int i=0; i<=N; i++) if(isPrime[i]) prime.add(i);
		int st=0, en=0;
		while(true) {
			if(sum>=N) {
				if(sum==N) ans++;
				sum-=prime.get(st++);
			} else {
				if(en==prime.size()) break;
				sum+=prime.get(en++);
			}
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}