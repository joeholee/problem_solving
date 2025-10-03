import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,sum,ans;
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		int l=0,r=N-1;
		ans = A[l]+A[r];
		while(l<r) {
			int sum = A[l]+A[r];
			if(Math.abs(sum)<Math.abs(ans)) ans=sum;
			if(sum>0) r--;
			else if(sum<0) l++;
			else {
				ans=0;
				break;
			}
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}