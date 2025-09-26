import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M,L,ans;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr = new int[N+2];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());
		arr[0]=0;
		arr[N+1]=L;
		Arrays.sort(arr);
		search(1,L-1);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void search(int left, int right) {
		while(left<=right) {
			int mid = (left+right)/2;
			int tmp=0;
			for(int i=0; i<=N; i++) tmp+=(arr[i+1]-arr[i]-1)/mid;
			if(tmp<=M) {
				ans=mid;
				right=mid-1;
			}
			else left=mid+1;
		}
	}
}