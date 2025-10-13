import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int ans;
	static String doc,word;
	
	public static void main(String[] args) throws IOException {
		doc = br.readLine();
		word = br.readLine();
		int dLen = doc.length();
		int wLen = word.length();
		int cur=0;
		for(int i=0; i<=dLen-wLen; ) {
			boolean match = true;
			for(int j=0; j<wLen; j++) {
				if(doc.charAt(i+j)!=word.charAt(j)) {
					match = false;
					break;
				}
			}
			if(match) {
				ans++;
				i+=wLen;
			}
			else i++;
		}
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}