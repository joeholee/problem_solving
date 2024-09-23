import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	static int N;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int X = Integer.parseInt(br.readLine());
			if(maxHeap.size()==minHeap.size()) maxHeap.add(X);
			else minHeap.add(X);
			if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek()>minHeap.peek()) {
				int tmpMax=maxHeap.poll();
				int tmpMin=minHeap.poll();
				maxHeap.add(tmpMin);
				minHeap.add(tmpMax);
			}
			sb.append(maxHeap.peek()).append("\n");
		}
		System.out.println(sb);
	}
}