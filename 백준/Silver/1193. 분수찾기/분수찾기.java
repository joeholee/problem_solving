import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int div,den,tmp=1;
	public static void main(String[] args) throws IOException {
		int X = Integer.parseInt(br.readLine());
		while(X>0) {
			if(tmp%2==0) {
				div=0;
				den=tmp+1;
			}
			else {
				div=tmp+1;
				den=0;
			}
			for(int i=1; i<=tmp; i++) {
				if(tmp==1) div=den=1;
				else {
					if(tmp%2==0) {
						div++;
						den--;
					}
					else {
						div--;
						den++;
					}
				}
				X--;
				if(X==0) break;
			}
			tmp++;
		}
		sb.append(div).append("/").append(den);
		System.out.print(sb);
	}
}