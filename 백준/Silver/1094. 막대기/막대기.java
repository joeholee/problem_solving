import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int X,ans;
	public static void main(String[] args) throws IOException {
		X = Integer.parseInt(br.readLine());
		while(X>0) {
			if(X%2==1) ans++;
			X/=2;
		}
		System.out.println(ans);
	}
}