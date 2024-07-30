import java.util.Scanner;
import java.util.Arrays;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int N;
		N=sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            int tmp = sc.nextInt();
            arr[i] = tmp;
        }
        Arrays.sort(arr);
        System.out.println(arr[N/2]);
	}
}