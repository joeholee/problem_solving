import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static String N;
	static int[] arr;
	static int sum;
	static List<Integer> li = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		N = br.readLine();
		arr = new int[N.length()];
		for(int i=0; i<N.length(); i++) {
			int num = N.charAt(i)-'0';
			li.add(num);
			sum+=num;
		}
		if(!li.contains(0)||sum%3!=0) sb.append(-1);
		else {
			Collections.sort(li, Collections.reverseOrder());
			for(int i : li) sb.append(i);
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}