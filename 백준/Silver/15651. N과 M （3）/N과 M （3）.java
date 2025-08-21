import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static int[] arr,num;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		num = new int[M];
		for(int i=0; i<N; i++) arr[i] = i+1;
		subset(0);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void subset(int cnt) {
		if(cnt==M) {
			for(int i : num) sb.append(i).append(' ');
			sb.append('\n');
			return;
		}
		for(int i=0; i<N; i++) {
			num[cnt]=arr[i];
			subset(cnt+1);
		}
	}
}