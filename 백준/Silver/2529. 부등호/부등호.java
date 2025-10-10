import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int k;
	static String min="", max="";
	static char[] sign;
	static boolean[] vis = new boolean[10];
	
	public static void main(String[] args) throws IOException {
		k = Integer.parseInt(br.readLine());
		sign = new char[k];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) sign[i] = st.nextToken().charAt(0);
		for(int i=0; i<10; i++) {
			vis[i]=true;
			dfs(1,String.valueOf(i));
			vis[i]=false;
		}
		sb.append(max).append('\n').append(min).append('\n');
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	static void dfs(int depth, String cur) {
		if(depth==k+1) {
			if(min.equals("")||cur.compareTo(min)<0) min=cur;
			if(max.equals("")||cur.compareTo(max)>0) max=cur;
			return;
		}
		for(int i=0; i<10; i++) {
			if(sign[depth-1]=='<') {
				if(!vis[i]&&cur.charAt(depth-1)-'0'<i) {
					vis[i]=true;
					dfs(depth+1,cur+i);
					vis[i]=false;
				}
			} else {
				if(!vis[i]&&cur.charAt(depth-1)-'0'>i) {
					vis[i]=true;
					dfs(depth+1,cur+i);
					vis[i]=false;
				}
			}
		}
	}
}