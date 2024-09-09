import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] arr,num;
	static boolean[] vis;
	static int N,M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		String[] sz = br.readLine().split(" ");
		N = Integer.parseInt(sz[0]);
		M = Integer.parseInt(sz[1]);
		arr = new int[N];
		num = new int[M];
		vis = new boolean[N];
		String[] nums = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(nums[i]);
		}
		Arrays.sort(arr);
		perm(0);
		System.out.println(sb);
	}
	
	static void perm(int cnt) {
		int prev=-1;
		if(cnt==M) {
			for(int i=0; i<M; i++) sb.append(num[i]).append(" ");
			sb.append("\n");
			return;
		}
		for(int i=0; i<N; i++) {
			if(!vis[i] && arr[i]!=prev) {
				prev=arr[i];
				num[cnt]=arr[i];
				vis[i]=true;
				perm(cnt+1);
				vis[i]=false;
			}
		}
	}
}