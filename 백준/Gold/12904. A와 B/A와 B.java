import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String S,T;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		S = br.readLine();
		T = br.readLine();
		dfs(T);
		bw.write(ans+"");
		bw.close();
		br.close();
	}
	
	static void dfs(String cur) {
		if(ans==1) return;
		if(cur.length()==S.length()) {
			if(cur.equals(S)) ans=1;
			return;
		}
		if(cur.charAt(cur.length()-1)=='A') dfs(cur.substring(0,cur.length()-1));
		if(cur.charAt(cur.length()-1)=='B') {
			StringBuffer sb = new StringBuffer(cur.substring(0,cur.length()-1));
			dfs(sb.reverse().toString());
		}
	}
}