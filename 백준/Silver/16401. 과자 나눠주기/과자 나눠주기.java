import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int M,N,ans;
	static int[] L;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		L = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			L[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(L);
		parametricSearch();
		System.out.println(ans);
	}
	
	static void parametricSearch() {
		int left=1;
		int right=L[N-1];
		while(left<=right) {
			int mid=(left+right)/2;
			int cnt=0;
			for(int i=0; i<N; i++) cnt+=L[i]/mid;
			if(cnt>=M) {
				ans=mid;
				left=mid+1;
			}
			else right=mid-1;
		}
	}
}