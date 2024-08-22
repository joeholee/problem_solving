import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static int N,M,i,j;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] arr, sum;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		sum = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int k=1; k<=N; k++) {
			arr[k]=Integer.parseInt(st.nextToken());
			sum[k]=sum[k-1]+arr[k];
		}
		for(int n=0; n<M; n++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			sb.append(sum[j]-sum[i-1]).append("\n");
		}
		System.out.println(sb);
	}
}