import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static char[] arr;
	static int zero,one;
	
	public static void main(String[] args) throws IOException {
		arr = br.readLine().toCharArray();
		for(int i=0; i<arr.length; i++) {
			if(arr[i]=='0') zero++;
			else one++;
		}
		
		zero/=2;
		one/=2;
		
		for(int i=0; i<arr.length && one>0; i++) {
			if(arr[i]=='1') {
				one--;
				arr[i]='2';
			}
		}
		for(int i=arr.length-1; i>=0 && zero>0; i--) {
			if(arr[i]=='0') {
				zero--;
				arr[i]='2';
			}
		}
		for(char c : arr) {
			if(c!='2') sb.append(c);
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}