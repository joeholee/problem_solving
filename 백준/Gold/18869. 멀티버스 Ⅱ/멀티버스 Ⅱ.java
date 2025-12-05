import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int M,N,ans;
	static int[][] arr;
	static List<List<Integer>> li = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		for(int i=0; i<M; i++) li.add(new ArrayList<>());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			Set<Integer> s = new HashSet<>();
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
				s.add(num);
			}
			li.set(i, new ArrayList<>(s));
			Collections.sort(li.get(i));
		}
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) arr[i][j] = Collections.binarySearch(li.get(i), arr[i][j]);
		}
		for(int i=0; i<M; i++) {
			for(int j=i+1; j<M; j++) {
				if(Arrays.equals(arr[i], arr[j])) ans++;
			}
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}