import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] isDivisor = new boolean[N+1];
        for(int i=1; i*i<=N; i++) {
        	if(N%i==0) {
            	isDivisor[i]=true;
                isDivisor[N/i]=true;
            }
        }
        for(int i=1; i<=N; i++) System.out.print(isDivisor[i] ? i+" " : "");
	}
}