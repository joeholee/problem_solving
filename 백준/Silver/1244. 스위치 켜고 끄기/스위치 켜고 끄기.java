import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int S,N;
	static int[] status;
	
	public static void main(String[] args) throws IOException {
		S = Integer.parseInt(br.readLine());
		status = new int[S];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<S; i++) status[i] = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(sex==1) {
				for(int i=num-1; i<S; i+=num) status[i] = 1-status[i];
			} else {
				int len = 0;
				for(int i=0; i<S; i++) {
					int ldx = num-1-i, rdx = num-1+i;
					if(ldx<0||rdx>=S) break;
					if(status[ldx]==status[rdx]) len++;
					else break;
				}
				status[num-1] = 1-status[num-1];
				for(int i=1; i<len; i++) {
					status[num-1-i] = 1-status[num-1-i];
					status[num-1+i] = 1-status[num-1+i];
				}
			}
		}
		for(int i=0; i<S; i++) {
			sb.append(status[i]).append(' ');
			if(i%20==19) sb.append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}