import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for( int tc = 1; tc <= T ; tc++ ) {
			String str = br.readLine();
			
			int result = 1;
			for( int i = 0 ; i < str.length()/2 + 1 ; i++) {
				if(str.charAt(i) != str.charAt(str.length()-i-1)) {
					result = 0;
				}
			}
		System.out.println( "#" + tc + " " + result );
		}
	}
}