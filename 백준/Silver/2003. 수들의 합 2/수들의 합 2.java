import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,M,l,r,sum,ans;
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) A[i]=Integer.parseInt(st.nextToken());
		while(true) {
			if(sum>=M) {
				if(sum==M) ans++;
				sum-=A[l++];
			} else {
				if(r==N) break;
				sum+=A[r++];
			}
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}