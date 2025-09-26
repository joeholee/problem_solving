import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M,ans;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		search(0,arr[N-1]);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void search(int left, int right) {
		while(left<=right) {
			long tmp = 0;
			int mid = (left+right)/2;
			for(int i : arr) if(i>mid) tmp+=(i-mid);
			if(tmp<M) right = mid-1;
			else {
				ans = mid;
				left = mid+1;
			}
		}
	}
}