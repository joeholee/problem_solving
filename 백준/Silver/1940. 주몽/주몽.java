import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] arr;
	static int N,M,ans;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i]=Integer.parseInt(st.nextToken());
		solve();
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void solve() {
		Arrays.sort(arr);
		int left=0;
		int right=N-1;
		while(left<right) {
			int sum = arr[left]+arr[right];
			if(sum==M) {
				ans++;
				left++;
				right--;
			}
			else if(sum>M) right--;
			else left++;
		}
	}
}
