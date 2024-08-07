import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int i=1;
        while(N>=0) {
        	System.out.print(i+" ");
            i*=2;
            N--;
        }
	}
}