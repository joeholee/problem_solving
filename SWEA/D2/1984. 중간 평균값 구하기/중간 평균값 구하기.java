import java.util.Scanner;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            double[] arr = new double[10];
            for(int i=0; i<10; i++) arr[i] = sc.nextInt();
            Arrays.sort(arr);
            double sum=0;
            for(int i=1; i<=8; i++) sum+=arr[i];
            double ans = Math.round(sum/8);
            System.out.println("#"+test_case+" "+(int)ans);
		}
	}
}