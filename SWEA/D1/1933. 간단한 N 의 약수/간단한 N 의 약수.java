import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> li = new ArrayList<>();
        for(int i=1; i*i<=N; i++) {
            if(N%i==0) {
            	if(!li.contains(i)) li.add(i);
                if(!li.contains(N/i)) li.add(N/i);
            }
        }
        Collections.sort(li);
        for(int i : li) System.out.print(i+" ");
	}
}