import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String[] arr;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new String[N];
		for(int i=0; i<N; i++) arr[i] = br.readLine();
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length()==s2.length()) {
					return s1.compareTo(s2);
				} else {
					return s1.length()-s2.length();
				}
			}
		});
		sb.append(arr[0]).append('\n');
		for(int i=1; i<N; i++) {
			if(!arr[i].equals(arr[i-1])) sb.append(arr[i]).append('\n');
		}
		System.out.println(sb);
	}
}