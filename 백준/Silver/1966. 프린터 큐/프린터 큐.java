import java.io.*;
import java.util.*;

public class Main {
	static class Document implements Comparable<Document> {
		int idx;
		int priority;
		
		Document(int idx, int priority) {
			this.idx=idx;
			this.priority=priority;
		}
		
		@Override
		public int compareTo(Document doc) {
			return doc.priority - this.priority;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T,N,M;
	
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			Deque<Document> dq = new ArrayDeque<>();
			PriorityQueue<Document> pq = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int priority = Integer.parseInt(st.nextToken());
				Document doc = new Document(i,priority);
				dq.offer(doc);
				pq.offer(doc);
			}
			int cnt=0;
			while(!dq.isEmpty()) {
				Document doc = dq.poll();
				if(doc.priority==pq.peek().priority) {
					cnt++;
					pq.poll();
					if(doc.idx==M) {
						sb.append(cnt).append('\n');
						break;
					}
				}
				else dq.offer(doc);
			}
		}
		System.out.println(sb);
	}
}