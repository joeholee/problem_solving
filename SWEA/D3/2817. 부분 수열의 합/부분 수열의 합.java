import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		//4:21 시작 4:40 종료 19분
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int sum;
			int cnt =0;
			
			// 부분집합의 개수, 첫번째 조합 => 1 << N
			for (int i = 0; i < (1 << N); i++) {
				sum=0;
				for (int j = 0; j < N; j++) {
					if((i & (1<<j)) != 0) {
						sum += arr[j];
					}
					
				
				}
				if(sum == K) {
					cnt++;
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
		
	}
}
