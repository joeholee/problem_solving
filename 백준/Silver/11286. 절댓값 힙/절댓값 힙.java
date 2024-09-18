import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PriorityQueue<Integer> pq;
	static StringBuilder sb = new StringBuilder();
	static int N,x;
	
	public static void main(String[] args) throws IOException {
		pq = new PriorityQueue<>((o1, o2) -> {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			if(abs1==abs2) return o1 > o2 ? 1 : -1;
			return abs1-abs2;
		});
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			x = Integer.parseInt(br.readLine());
			if(x==0) {
				if(!pq.isEmpty()) sb.append(pq.poll()).append("\n");
				else sb.append(0).append("\n");
			}
			else pq.add(x);
		}
		System.out.println(sb);
	}
}