import java.io.*;
import java.util.*;

public class Main {
	static String S;
	static Set<String> s = new HashSet<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		S = br.readLine();
		for(int i=0; i<S.length(); i++) {
			for(int j=i+1; j<S.length()+1; j++) s.add(S.substring(i,j));
		}
		System.out.println(s.size());
	}
}