import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int[] arr = new int[10];
            
            for(int i = 0; i<arr.length; i++) {
            	arr[i] = sc.nextInt();
            }
            
            Arrays.sort(arr);
            
            System.out.println("#"+test_case+" " +arr[arr.length-1]);
 			
		}
	}
}