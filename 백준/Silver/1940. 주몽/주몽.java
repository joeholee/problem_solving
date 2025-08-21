import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] arr,num;
	static int N,M,ans;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new int[N];
		num = new int[2];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i]=Integer.parseInt(st.nextToken());
		comb(0,0);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void comb(int idx, int cnt) {
		if(cnt==2) {
			int tmp=0;
			for(int i : num) tmp+=i;
			if(tmp==M) ans++;
			return;
		}
		for(int i=idx; i<N; i++) {
			num[cnt]=arr[i];
			comb(i+1,cnt+1);
		}
	}
}
