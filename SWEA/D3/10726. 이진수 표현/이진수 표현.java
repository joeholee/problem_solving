import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int TC;
		TC=sc.nextInt();
		for(int test_case = 1; test_case <= TC; test_case++)
		{
            int N = sc.nextInt();
            int M = sc.nextInt();
            int X = (1<<N) - 1;
            if((M&X)==X) System.out.println("#"+test_case+" "+"ON");
            else System.out.println("#"+test_case+" "+"OFF");
		}
	}
}