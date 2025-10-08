import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n,m;
	static long ans;
	static long[] a;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for(long i : a) pq.offer(i);
		for(int i=0; i<m; i++) {
			long b = pq.poll();
			long c = pq.poll();
			pq.offer(b+c);
			pq.offer(b+c);
		}
		while(!pq.isEmpty()) ans+=pq.poll();
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}