import java.util.Scanner;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int T = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();
            int ans = rec(N,M);
            System.out.println("#"+T+" "+ans);
        }
    }
     
    static int rec(int N, int M) {
        if(M==1) return N;
        if(M%2==0) {
            int tmp=rec(N,M/2);
            return tmp*tmp;
        }
        else {
            int tmp=rec(N,(M-1)/2);
            return N*tmp*tmp;
        }
    }
}