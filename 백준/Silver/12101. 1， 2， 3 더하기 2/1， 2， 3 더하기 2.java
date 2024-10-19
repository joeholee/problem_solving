import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n,k;
	static List<String>[] arr;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new ArrayList[n+3];
		for(int i=0; i<n+3; i++) arr[i]=new ArrayList<>();
		arr[1].add("1");
		arr[2].add("1+1");
		arr[2].add("2");
		arr[3].add("1+1+1");
		arr[3].add("1+2");
		arr[3].add("2+1");
		arr[3].add("3");
		for(int i=4; i<=n; i++) {
			for(int j=1; j<=3; j++) {
				for(String op : arr[i-j]) {
					arr[i].add(op+"+"+j);
				}
			}
		}
		if(arr[n].size()<k) System.out.println(-1);
		else {
			Collections.sort(arr[n]);
			System.out.println(arr[n].get(k-1));
		}
	}
}