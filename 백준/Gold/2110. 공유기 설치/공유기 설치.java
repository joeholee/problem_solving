import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,C,ans;
	static int[] x;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		x = new int[N];
		for(int i=0; i<N; i++) x[i]=Integer.parseInt(br.readLine());
		Arrays.sort(x);
		parametricSearch();
		System.out.println(ans);
	}
	
	static void parametricSearch() {
		int left=0;
		int right=x[N-1]-x[0]; // 간격
		while(left<=right) {
			int cnt=1; // 첫번째집 설치 가정
			int cur=x[0]; // 첫번째집
			int mid=(left+right)/2;
			// 두번째집부터 탐색하는데
			for(int i=1; i<N; i++) {
				// 직전에 설치한 집과 현재 집 거리를 비교
				// 이 거리가 최소 거리보다 크거나 같으면 업데이트
				if(x[i]-cur>=mid) {
					cnt++;
					cur=x[i];
				}
			}
			if(cnt>=C) {
				ans=mid;
				left=mid+1;
			}
			else right=mid-1;
		}
	}
}