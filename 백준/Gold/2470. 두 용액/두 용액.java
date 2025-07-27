import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] arr,ans;
	static int left,right,sum,min=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		ans = new int[2];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		solve();
		System.out.println(sb);
	}
	
	static void solve() {
		left=0;
		right=N-1;
		while(left<right) {
			sum = arr[left]+arr[right];
			if(min>Math.abs(sum)) {
				min=Math.abs(sum);
				ans[0]=arr[left];
				ans[1]=arr[right];
				if(sum==0) break;
			}
			if(sum<0) left++;
			else right--;
		}
		sb.append(ans[0]).append(' ').append(ans[1]);
	}
}