import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,arr[][];
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, (o1,o2) -> {
			if(o1[0]==o2[0]) return Integer.compare(o1[1], o2[1]);
			else return Integer.compare(o1[0],o2[0]);
		});
		for(int i=0; i<N; i++) {
			if(pq.isEmpty()) pq.offer(arr[i][1]);
			else {
				if(pq.peek()<=arr[i][0]) pq.poll();
				pq.offer(arr[i][1]);
			}
		}
		bw.write(pq.size()+"");
		bw.close();
		br.close();
	}
}