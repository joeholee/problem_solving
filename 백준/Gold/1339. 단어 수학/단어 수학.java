import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N,ans;
	static int[] val = new int[26];
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String S = br.readLine();
			for(int j=0; j<S.length(); j++) val[S.charAt(j)-'A']+=(int) Math.pow(10,S.length()-j-1);
		}
		Arrays.sort(val);
		for(int i=25; i>16; i--) ans+=val[i]*(i-16);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}