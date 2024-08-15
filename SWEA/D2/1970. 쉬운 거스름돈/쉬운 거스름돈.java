import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	static int[] change = {50000,10000,5000,1000,500,100,50,10};
	static int[] amount;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        amount = new int[8];
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	int N = Integer.parseInt(br.readLine());
        	for(int i=0; i<8; i++) {
        		amount[i]=N/change[i];
        		N%=change[i];
        	}
        	System.out.println("#"+test_case);
        	for(int i : amount) System.out.print(i+" ");
        	System.out.println();
        }
        
    }
}