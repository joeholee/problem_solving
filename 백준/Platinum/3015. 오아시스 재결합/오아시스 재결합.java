import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int[] height;
	static long ans;
	static Deque<int[]> st = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		height = new int[N];
		for(int i=0; i<N; i++) height[i] = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int cur = height[i];
			int cnt = 1;
			while(!st.isEmpty()&&cur>=st.peek()[0]) {
				ans+=st.peek()[1];
				if(cur==st.peek()[0]) cnt+=st.peek()[1];
				st.pop();
			}
			if(!st.isEmpty()) ans++;
			st.push(new int[] {cur,cnt});
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}