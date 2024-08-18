import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] arr;
	public static void main(String args[]) throws Exception
    {
    	int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	int N = Integer.parseInt(br.readLine());
        	arr = new int[N+1][N+1];
        	for(int i=1; i<=N; i++) {
        		for(int j=1; j<=i; j++) {
        			if(i==1) arr[i][j]=1;
        			else {
        				if(j==1) arr[i][j]=1;
        				else if(j==i) arr[i][j]=1;
        				else arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
        			}
        		}
        	}
            System.out.println("#"+test_case);
            for(int i=1; i<=N; i++) {
            	for(int j=1; j<=i; j++) System.out.print(arr[i][j]+" ");
                System.out.println();
            }
        }
    }
}