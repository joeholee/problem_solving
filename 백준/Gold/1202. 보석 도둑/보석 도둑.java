import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,K,cnt;
	static long ans;
	static Jewel[] jewels;
	static int[] bags;
	
	static class Jewel implements Comparable<Jewel> {
		int M,V;
		
		Jewel(int M, int V) {
			this.M = M;
			this.V = V;
		}
		
		@Override
		public int compareTo(Jewel j) {
			if(M==j.M) return Integer.compare(j.V, V);
			return Integer.compare(M, j.M);
		}
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		jewels = new Jewel[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			jewels[i] = new Jewel(m,v);
		}
		bags = new int[K];
		for(int i=0; i<K; i++) bags[i] = Integer.parseInt(br.readLine());
		Arrays.sort(jewels);
		Arrays.sort(bags);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<K; i++) {
			while(cnt<N && jewels[cnt].M<=bags[i]) {
				pq.offer(jewels[cnt].V);
				cnt++;
			}
			if(!pq.isEmpty()) ans+=pq.poll();
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}