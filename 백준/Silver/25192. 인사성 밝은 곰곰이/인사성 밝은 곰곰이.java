import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N,ans;
	static Set<String> s = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			if(input.equals("ENTER")) s.clear();
			else {
				if(!s.contains(input)) {
					s.add(input);
					ans++;
				}
			}
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}