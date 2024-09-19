import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T,M;
	static PriorityQueue<Integer> minHeap,maxHeap;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			minHeap = new PriorityQueue<>();
			maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			M = Integer.parseInt(br.readLine());
			sb.append(M/2+1).append("\n");
			int cnt=0;
			int output=0;
			for(int i=0; i<M; i++) {
				if(i%10==0) st = new StringTokenizer(br.readLine());
				int cur = Integer.parseInt(st.nextToken());
				if(maxHeap.isEmpty() || cur <= maxHeap.peek()) maxHeap.add(cur);
				else minHeap.add(cur);
				if(maxHeap.size() > minHeap.size()+1) minHeap.add(maxHeap.poll());
				else if(minHeap.size() > maxHeap.size()) maxHeap.add(minHeap.poll());
				if(i%2==0) {
					sb.append(maxHeap.peek()).append(" ");
					output++;
					if(output%10==0) sb.append("\n");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}