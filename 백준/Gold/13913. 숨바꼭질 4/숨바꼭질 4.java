import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
	static int N,K,cur,pushItem;
	static int[] dist = new int[100001];
	static int[] vis = new int[100001];
	static Queue<Integer> q = new LinkedList<>();
	static Stack<Integer> st = new Stack<>();
	static List<Integer> li = new ArrayList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] sz = br.readLine().split(" ");
		N = Integer.parseInt(sz[0]);
		K = Integer.parseInt(sz[1]);
		Arrays.fill(dist,-1);
		if(N==K) {
			System.out.println(0);
			System.out.println(N);
			return;
		}
		bfs();
		System.out.println(dist[K]);
		pushItem=K;
		st.push(pushItem);
		while(pushItem!=N) {
			pushItem=vis[pushItem];
			st.push(pushItem);
		}
		while(!st.isEmpty()) System.out.print(st.pop()+" ");
	}
	
	static void bfs() {
		q.add(N);
		dist[N]=0;
		while(!q.isEmpty()) {
			cur = q.poll();
			int[] nxt = new int[] {cur-1, cur+1, 2*cur};
			for(int n : nxt) {
				if(n<0||n>100000) continue;
				if(dist[n]>=0||vis[n]>0) continue;
				dist[n]=dist[cur]+1;
				vis[n]=cur;
				q.add(n);
			}
 		}
	}
}