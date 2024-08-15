import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	static int[] divisor;
    public static void main(String args[]) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	int N = Integer.parseInt(br.readLine());
        	divisor = new int[5];
        	while(N>1) {
        		if(N%2==0) {
        			N/=2;
        			divisor[0]++;
        			continue;
        		}
        		if(N%3==0) {
        			N/=3;
        			divisor[1]++;
        			continue;
        		}
        		if(N%5==0) {
        			N/=5;
        			divisor[2]++;
        			continue;
        		}
        		if(N%7==0) {
        			N/=7;
        			divisor[3]++;
        			continue;
        		}
        		if(N%11==0) {
        			N/=11;
        			divisor[4]++;
        			continue;
        		}
        	}
        	System.out.print("#"+test_case+" ");
        	for(int d : divisor) System.out.print(d+" ");
        	System.out.println();
        }
    }
}