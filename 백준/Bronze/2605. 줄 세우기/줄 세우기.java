import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] q;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		q = new int[N+1];
		for(int i=1; i<=N; i++) q[i]=i;
		st = new StringTokenizer(br.readLine());
		for(int idx=1; idx<=N; idx++) {
			int dist = Integer.parseInt(st.nextToken());
			int tmp = idx;
			while(dist>0) {
				swap(tmp,tmp-1);
				tmp--;
				dist--;
			}
		}
		for(int i=1; i<=N; i++) System.out.print(q[i]+" ");
	}
	
	static void swap(int i, int j) {
		int tmp = q[i];
		q[i] = q[j];
		q[j] = tmp;
	}
}