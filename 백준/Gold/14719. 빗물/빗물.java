import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int H,W,ans;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new int[W];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++) arr[i] = Integer.parseInt(st.nextToken());
		for(int i=0; i<W; i++) {
			int maxL=0,maxR=0;
			for(int j=0; j<i; j++) maxL = Math.max(maxL, arr[j]);
			for(int j=W-1; j>i; j--) maxR = Math.max(maxR, arr[j]);
			int height = Math.min(maxL, maxR);
			ans+=(Math.max(height-arr[i], 0));
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}