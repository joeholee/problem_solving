import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	static int N,M;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] arr,num;
	
	public static void main(String[] args) throws IOException {
		String[] sz = br.readLine().split(" ");
		N = Integer.parseInt(sz[0]);
		M = Integer.parseInt(sz[1]);
		arr = new int[N];
		num = new int[M];
		String[] input = br.readLine().split(" ");
		for(int i=0; i<N; i++) arr[i]=Integer.parseInt(input[i]);
		Arrays.sort(arr);
		perm(0,0);
		System.out.println(sb);
	}
	
	static void perm(int cnt, int idx) {
		if(cnt==M) {
			for(int n : num) sb.append(n).append(" ");
			sb.append("\n");
			return;
		}
		for(int i=idx; i<N; i++) {
			num[cnt]=arr[i];
			perm(cnt+1,i);
		}
	}
}