import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
            String[] time = br.readLine().split(" ");
            int h1 = Integer.parseInt(time[0]);
            int m1 = Integer.parseInt(time[1]);
            int h2 = Integer.parseInt(time[2]);
            int m2 = Integer.parseInt(time[3]);
            int ansH=h1+h2;
            int ansM=m1+m2;
            if(ansM>=60) {
            	ansM-=60;
                ansH+=1;
            }
            if(ansH>12) ansH-=12;
            System.out.println("#"+test_case+" "+ansH+" "+ansM);
		}
	}
}