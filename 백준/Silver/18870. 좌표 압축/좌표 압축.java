import java.io.*;
import java.util.*;

public class Main {
	static int N,idx;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] arr,sor;
	static Map<Integer, Integer> m = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		sor = arr.clone();
		Arrays.sort(sor);
		for(int i : sor) {
			if(!m.containsKey(i)) m.put(i, idx++);
		}
		for(int i : arr) {
			sb.append(m.get(i)).append(' ');
		}
		System.out.println(sb);
	}
}