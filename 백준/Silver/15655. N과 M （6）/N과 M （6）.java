import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	static int N,M;
	static int[] arr,num;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		String[] sz = br.readLine().split(" ");
		N = Integer.parseInt(sz[0]);
		M = Integer.parseInt(sz[1]);
		arr = new int[N];
		num = new int[M];
		String[] nums = br.readLine().split(" ");
		for(int i=0; i<N; i++) arr[i]=Integer.parseInt(nums[i]);
		Arrays.sort(arr);
		comb(0,0);
		System.out.println(sb);
	}
	
	static void comb(int cnt, int idx) {
		if(cnt==M) {
			for(int n : num) sb.append(n).append(" ");
			sb.append("\n");
			return;
		}
		for(int i=idx; i<N; i++) {
			num[cnt]=arr[i];
			comb(cnt+1,i+1);
		}
	}
}