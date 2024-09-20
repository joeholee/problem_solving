import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Long> pq;
	static int T,K;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			K = Integer.parseInt(br.readLine());
			pq = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<K; i++) pq.add(Long.parseLong(st.nextToken()));
			solve();
		}
		System.out.println(sb);
	}
	
	static void solve() {
		long sum=0;
		while(!pq.isEmpty()) {
			long i1=pq.poll();
			long i2=pq.poll();
			sum+=i1+i2;
			if(pq.isEmpty()) break;
			pq.add(i1+i2);
		}
		sb.append(sum).append("\n");
	}
}