import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N,M,x,y,K;
	static int[][] arr;
	
	static class Dice {
		int x,y;
		int[] faces = new int[6]; // top back right left front bottom
		
		Dice(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		void roll(int dir) {
			switch(dir) {
			case 1:
				if(y+1<M) {
					int tmp = faces[0];
					faces[0] = faces[3];
					faces[3] = faces[5];
					faces[5] = faces[2];
					faces[2] = tmp;
					if(arr[x][y+1]==0) arr[x][y+1] = faces[5];
					else {
						faces[5] = arr[x][y+1];
						arr[x][y+1]=0;
					}
					y++;
					sb.append(faces[0]).append('\n');
				}
				break;
			case 2:
				if(y-1>=0) {
					int tmp = faces[0];
					faces[0] = faces[2];
					faces[2] = faces[5];
					faces[5] = faces[3];
					faces[3] = tmp;
					if(arr[x][y-1]==0) arr[x][y-1] = faces[5];
					else {
						faces[5] = arr[x][y-1];
						arr[x][y-1]=0;
					}
					y--;
					sb.append(faces[0]).append('\n');
				}
				break;
			case 3:
				if(x-1>=0) {
					int tmp = faces[0];
					faces[0] = faces[4];
					faces[4] = faces[5];
					faces[5] = faces[1];
					faces[1] = tmp;
					if(arr[x-1][y]==0) arr[x-1][y] = faces[5];
					else {
						faces[5] = arr[x-1][y];
						arr[x-1][y]=0;
					}
					x--;
					sb.append(faces[0]).append('\n');
				}
				break;
			case 4:
				if(x+1<N) {
					int tmp = faces[0];
					faces[0] = faces[1];
					faces[1] = faces[5];
					faces[5] = faces[4];
					faces[4] = tmp;
					if(arr[x+1][y]==0) arr[x+1][y] = faces[5];
					else {
						faces[5] = arr[x+1][y];
						arr[x+1][y]=0;
					}
					x++;
					sb.append(faces[0]).append('\n');
				}
				break;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) arr[r][c] = Integer.parseInt(st.nextToken());
		}
		Dice dice = new Dice(x,y);
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) dice.roll(Integer.parseInt(st.nextToken()));
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}