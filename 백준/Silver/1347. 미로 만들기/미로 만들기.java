import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] arr = new int[101][101];
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,-1,0,1};
	static int cnt,curr=50,curc=50,minr=50,maxr=50,minc=50,maxc=50;
	public static void main(String[] args) throws IOException {
		cnt = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int dir=0;
		arr[curr][curc]=1;
		for(int i=0; i<cnt; i++) {
			char ch = input.charAt(i);
			if(ch=='R') dir = (dir+1)%4;
			else if(ch=='L') {
				dir--;
				if(dir==-1) dir=3;
			}
			else {
				curr+=dr[dir];
				curc+=dc[dir];
				arr[curr][curc]=1;
				minr = Math.min(minr,curr);
				minc = Math.min(minc,curc);
				maxr = Math.max(maxr,curr);
				maxc = Math.max(maxc,curc);
			}
		}
		for(int r=minr; r<=maxr; r++) {
			for(int c=minc; c<=maxc; c++) {
				if(arr[r][c]==1) System.out.print(".");
				else System.out.print("#");
			}
			System.out.println();
		}
	}
}