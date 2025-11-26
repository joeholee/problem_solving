import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,K,ans=Integer.MAX_VALUE;
	static int[] arr;
	static List<Integer> li = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i]==1) li.add(i);
		}
		if(li.size()<K) ans=-1;
		else {
			for(int i=0; i<=li.size()-K; i++) {
				int lo = li.get(i);
				int hi = li.get(i+K-1);
				ans = Math.min(ans, hi-lo+1);
			}
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}