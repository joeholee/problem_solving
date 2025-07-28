import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static Queue<Integer> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) q.add(i+1);
		while(q.size()>1) {
			q.remove();
			q.add(q.poll());
		}
		System.out.println(q.poll());
	}
}