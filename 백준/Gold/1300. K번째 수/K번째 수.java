import java.io.*;

public class Main {
	static int N,k;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		long left=1, right=k, ans=0;
		while(left<=right) {
			long mid = (left+right)/2;
			long cnt = 0;
			for(int i=1; i<=N; i++) cnt+=Math.min(mid/i, N);
			if(cnt<k) left=mid+1;
			else {
				ans=mid;
				right=mid-1;
			}
		}
		System.out.println(ans);
	}
}