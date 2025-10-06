import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static Lecture[] l;
	
	static class Lecture implements Comparable<Lecture> {
		int S,T;
		
		Lecture(int S, int T) {
			this.S = S;
			this.T = T;
		}
		
		@Override
		public int compareTo(Lecture l) {
			if(S==l.S) return Integer.compare(T, l.T);
			return Integer.compare(S, l.S);
		}
	}
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		l = new Lecture[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			l[i] = new Lecture(s,t);
		}
		Arrays.sort(l);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(l[0].T);
		for(int i=1; i<N; i++) {
			if(pq.peek()<=l[i].S) pq.poll();
			pq.offer(l[i].T);
		}
		bw.write(pq.size()+"");
		bw.close();
		br.close();
	}
}