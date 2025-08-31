import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int T,n;
	static int[] pre,in;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			n = Integer.parseInt(br.readLine());
			pre = new int[n];
			in = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) pre[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) in[i] = Integer.parseInt(st.nextToken());
			find(0,0,n-1);
			sb.append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void find(int root, int start, int end) {
		if(root>=n) return;
		int val = pre[root];
		for(int i=start; i<=end; i++) {
			if(val==in[i]) {
				find(root+1,start,i);
				find(root+i-start+1,i+1,end);
				sb.append(val).append(" ");
			}
		}
	}
}
