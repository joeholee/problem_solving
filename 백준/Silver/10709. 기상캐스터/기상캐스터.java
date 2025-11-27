import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int H,W;
	static char[][] arr;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new char[H][W];
		for(int r=0; r<H; r++) {
			String line = br.readLine();
			for(int c=0; c<W; c++) arr[r][c] = line.charAt(c);
		}
		for(int r=0; r<H; r++) {
			int last=-1;
			for(int c=0; c<W; c++) {
				if(arr[r][c]=='c') last=c;
				if(last!=-1) sb.append(c-last).append(' ');
				else sb.append(-1).append(' ');
			}
			sb.append('\n');
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}