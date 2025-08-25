import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N,cnt,range;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		cnt=1;
		range=2;
		if(N!=1) {
			while(range<=N) {
				range+=(6*cnt);
				cnt++;
			}
		}
		bw.write(cnt+"");
		bw.close();
		br.close();
	}
}
