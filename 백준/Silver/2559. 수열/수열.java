import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,K,sum,ans;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		int l=0;
		int r=K;
		for(int i=0; i<K; i++) sum+=arr[i];
		ans=sum;
		while(r<N) {
			sum-=arr[l];
			l++;
			sum+=arr[r];
			r++;
			ans = Math.max(ans, sum);
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}