import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,a,b,ans;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) pq.add(Integer.parseInt(br.readLine()));
		while(pq.size()>=2) {
			a = pq.poll();
			b = pq.poll();
			ans+=a+b;
			if(pq.isEmpty()) break;
			else pq.add(a+b);
		}
		System.out.println(ans);
	}
}