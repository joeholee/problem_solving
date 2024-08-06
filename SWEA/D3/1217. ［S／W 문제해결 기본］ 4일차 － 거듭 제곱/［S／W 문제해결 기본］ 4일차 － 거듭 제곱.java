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
            System.out.println("#"+T+" "+pow(N,M));
        }
    }
     
    static int pow(int N, int M) {
        if(M==1) return N;
        return N*pow(N,M-1);
    }
}