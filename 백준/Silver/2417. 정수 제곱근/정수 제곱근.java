import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static long n,ans=Long.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		n = Long.parseLong(br.readLine());
		long st=0, en=n;
		while(st<=en) {
			long mid = (st+en)/2;
			if(Math.pow(mid,2)>=n) {
				ans = mid;
				en = mid-1;
			} else st=mid+1;
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}