import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class Main {
	static int N;
	static int[][] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int r=0; r<N; r++) {
			String[] input = br.readLine().split(" ");
			for(int c=0; c<N; c++) arr[r][c] = Integer.parseInt(input[c]);
		}
		System.out.println(pool(0,0,N));
	}
	
	static int pool(int r, int c, int size) {
		if(size==2) {
			int[] cmp = new int[4];
			int idx=0;
			for(int i=r; i<r+2; i++) {
				for(int j=c; j<c+2; j++) cmp[idx++]=arr[i][j];
			}
			Arrays.sort(cmp);
			return cmp[2];
		}
		int[] cmp = new int[4];
		size/=2;
		cmp[0]=pool(r,c,size);
		cmp[1]=pool(r,c+size,size);
		cmp[2]=pool(r+size,c,size);
		cmp[3]=pool(r+size,c+size,size);
		Arrays.sort(cmp);
		return cmp[2];
	}
}