import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		for(int i=0; i<N; i++) sb.append(arr[i]).append('\n');
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}