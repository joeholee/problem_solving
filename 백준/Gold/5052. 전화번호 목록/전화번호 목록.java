import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int tc,n;
	static String[] number;
	
	public static void main(String[] args) throws IOException {
		tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; t++) {
			n = Integer.parseInt(br.readLine());
			number = new String[n];
			for(int i=0; i<n; i++) number[i] = br.readLine();
			Arrays.sort(number);
			boolean ok = true;
			for(int i=0; i<n-1; i++) {
				if(number[i+1].startsWith(number[i])) {
					ok = false;
					break;
				}
			}
			sb.append(ok ? "YES" : "NO").append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}