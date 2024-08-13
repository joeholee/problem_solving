import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    static int[][] arr;
    static int[][] arr_90;
    static int[][] arr_180;
    static int[][] arr_270;
    
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            arr_90 = new int[N][N];
            arr_180 = new int[N][N];
            arr_270 = new int[N][N];
            for(int r=0; r<N; r++) {
                String[] row = br.readLine().split(" ");
            	for(int c=0; c<N; c++) arr[r][c]=Integer.parseInt(row[c]);
            }
            for(int r=0; r<N; r++) {
            	for(int c=0; c<N; c++) arr_90[r][c]=arr[N-1-c][r];
            }
            for(int r=0; r<N; r++) {
            	for(int c=0; c<N; c++) arr_180[r][c]=arr_90[N-1-c][r];
            }
            for(int r=0; r<N; r++) {
            	for(int c=0; c<N; c++) arr_270[r][c]=arr_180[N-1-c][r];
            }
            System.out.println("#"+test_case);
            for(int r=0; r<N; r++) {
            	for(int i : arr_90[r]) System.out.print(i);
                System.out.print(" ");
                for(int i : arr_180[r]) System.out.print(i);
                System.out.print(" ");
                for(int i : arr_270[r]) System.out.print(i);
                System.out.println();
            }
		}
	}
}