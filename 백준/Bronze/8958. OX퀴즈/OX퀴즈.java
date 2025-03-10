import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static int N,tmp,ans;
	static String input;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		while(N>0) {
			input = br.readLine();
			for(char c : input.toCharArray()) {
				if(c=='O') {
					tmp++;
					ans+=tmp;
				} else tmp=0;
			}
			System.out.println(ans);
			N--;
			ans=0;
			tmp=0;
		}
	}
}