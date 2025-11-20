import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[][] P = new int[3][2];
	static int ans;
 	
	public static void main(String[] args) throws IOException {
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			P[i][0] = Integer.parseInt(st.nextToken());
			P[i][1] = Integer.parseInt(st.nextToken());
		}
		long x1 = P[1][0]-P[0][0];
        long y1 = P[1][1]-P[0][1];
        long x2 = P[2][0]-P[1][0];
        long y2 = P[2][1]-P[1][1];
        long cross = x1*y2 - y1*x2;
        if(cross>0) ans=1;
        else if(cross<0) ans=-1;
        else ans=0;
		bw.write(ans+"");
		bw.close();
		br.close();
	}
}