import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int k;
	static int[] arr;
	static int[] num = new int[6];
	
	public static void main(String[] args) throws IOException {
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k==0) break;
			arr = new int[k];
			for(int i=0; i<k; i++) arr[i] = Integer.parseInt(st.nextToken());
			comb(0,0);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void comb(int cnt, int idx) {
		if(cnt==6) {
			for(int i : num) sb.append(i).append(" ");
			sb.append("\n");
			return;
		}
		for(int i=idx; i<k; i++) {
			num[cnt]=arr[i];
			comb(cnt+1,i+1);
		}
	}
}