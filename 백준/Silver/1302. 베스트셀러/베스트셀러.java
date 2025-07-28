import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,val;
	static String ans;
	static Map<String,Integer> map = new TreeMap<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String book = br.readLine();
			map.put(book, map.getOrDefault(book, 0)+1);
		}
		for(Map.Entry<String,Integer> e : map.entrySet()) {
			if(e.getValue()>val) {
				val=e.getValue();
				ans=e.getKey();
			}
		}
		System.out.println(ans);
	}
}