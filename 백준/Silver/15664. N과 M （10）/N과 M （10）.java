import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		comb(0,0);
		System.out.println(sb);
	}
	
	static void comb(int cnt, int idx) {
		int prev=-1;
		if(cnt==M) {
			for(int i : num) sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		for(int i=idx; i<N; i++) {
			if(arr[i]!=prev) {
				prev=arr[i];
				num[cnt]=arr[i];
				comb(cnt+1,i+1);
			}
		}
	}
}