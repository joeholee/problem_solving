import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[100][100];
		for(int tc=1; tc<=10; tc++) {
			int T = Integer.parseInt(br.readLine());
			for(int i=0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) arr[i][j]=Integer.parseInt(st.nextToken());
			}
			int curR=99;
			int curC=0;
			for(int i=0; i<100; i++) {
				if(arr[99][i]==2) {
					curC=i;
					break;
				}
			}
			while(curR>0) {
				if(curC-1>=0 && curC-1<100 && arr[curR][curC-1]!=0) {
					arr[curR][curC]=0;
					curC--;
					continue;
				}
				if(curC+1>=0 && curC+1<100 && arr[curR][curC+1]!=0) {
					arr[curR][curC]=0;
					curC++;
					continue;
				}
				arr[curR][curC]=0;
				curR--;
			}
			System.out.println("#"+T+" "+curC);
		}
	}
}