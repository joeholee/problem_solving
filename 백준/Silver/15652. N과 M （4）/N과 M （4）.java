import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static int N,M;
	static int[] num;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		String[] sz = br.readLine().split(" ");
		N = Integer.parseInt(sz[0]);
		M = Integer.parseInt(sz[1]);
		num = new int[M];
		perm(1,0);
		System.out.println(sb);
	}
	
	static void perm(int idx, int cnt) {
		if(cnt==M) {
			for(int i : num) sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		for(int i=idx; i<N+1; i++) {
			num[cnt]=i;
			perm(i,cnt+1);
		}
	}
}