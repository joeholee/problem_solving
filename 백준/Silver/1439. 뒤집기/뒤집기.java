import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String S;
	static int zero,one;
	
	public static void main(String[] args) throws IOException {
		S = br.readLine();
		if(S.charAt(0)=='0') zero++;
		else one++;
		for(int i=1; i<S.length(); i++) {
			if(S.charAt(i)!=S.charAt(i-1)) {
				if(S.charAt(i)=='0') zero++;
				else one++;
			}
		}
		bw.write(Math.min(zero, one)+"");
		bw.close();
		br.close();
	}
}