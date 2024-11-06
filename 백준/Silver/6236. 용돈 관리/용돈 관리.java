import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M,K,max,sum;
	static int[] expenses;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N일동안
		M = Integer.parseInt(st.nextToken()); // M번 인출
		expenses = new int[N]; // 사용할 금액의 배열
		for(int i=0; i<N; i++) {
			expenses[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, expenses[i]);
			sum += expenses[i];
		}
		
		int left = max;
		int right = sum;
		K = sum;
		while(left <= right) {
			int mid = (left+right)/2;
			if(canWithdraw(mid)) {
				K = mid;
				right = mid-1;
			}
			else left = mid+1;
		}
		System.out.println(K);
	}
	
	static boolean canWithdraw(int amount) {
		int count = 1; // 인출 한번하고 시작
		int balance = amount;
		for(int expense : expenses) {
			if(balance < expense) {
				count++;
				balance = amount;
			}
			balance -= expense;
		}
		return count <= M;
	}
}