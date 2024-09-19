import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int t,n;
	static long ans;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			arr = new int[n];
			for(int j=0; j<n; j++) arr[j]=Integer.parseInt(st.nextToken());
			solve();
			sb.append(ans).append("\n");
			ans=0;
		}
		System.out.println(sb);
	}
	
	static void solve() {
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) ans+=gcd(arr[i],arr[j]);
		}
	}
	
	static int gcd(int p, int q) {
		if(q==0) return p;
		return gcd(q, p%q);
	}
}