import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int startIdx=1;
	static int cnt=0;
	static boolean done=false;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int[] vis = new int[input.length+1];
		for(int i=0; i<input.length; i++) {
			if(input[i]=='Y') vis[i+1]=1;
			else vis[i+1]=0;
		}
		out: while(startIdx<=input.length && !done) {
			for(int i=startIdx; i<=input.length; i++) {
				if(vis[i]==1) {
					startIdx=i;
					break;
				}
				if(i==input.length || done) break out;
			}
			light(vis, startIdx);
		}
		boolean able=true;
		for(int i=1; i<vis.length; i++) {
			if(vis[i]==1) {
				able=false;
				break;
			}
		}
		System.out.print(able ? cnt : -1);
	}
	
	static void light(int[] vis, int startIdx) {
		for(int i=startIdx; i<vis.length; i++) {
			if(i%startIdx == 0) vis[i] = 1-vis[i];
		}
		cnt++;
		for(int i=startIdx; i<vis.length; i++) {
			if(vis[i]==1) return;
		}
		done=true;
	}
}
