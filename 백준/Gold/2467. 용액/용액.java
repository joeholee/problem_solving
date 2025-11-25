import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int lo=0, hi=N-1, left=0, right=0;
		long min = Long.MAX_VALUE;
		while(lo<hi) {
			long sum = arr[lo]+arr[hi];
			if(min>Math.abs(sum)) {
				min = Math.abs(sum);
				left=lo; right=hi;
			}
			if(sum>=0) hi--;
			else lo++;
		}
		sb.append(arr[left]).append(' ').append(arr[right]);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}