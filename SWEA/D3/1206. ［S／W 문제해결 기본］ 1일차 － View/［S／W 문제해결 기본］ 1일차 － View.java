import java.util.Scanner;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int N;
            N = sc.nextInt();
            int[] arr = new int[N];
            for(int i=0; i<N; i++) arr[i] = sc.nextInt();
            int ans=0;
            out: for(int i=2; i<N-2; i++) {
                int tmp=0;
                for(int j=i-2; j<i; j++) {
                    if(arr[j]>=arr[i]) continue out;
                    if(arr[j]>=tmp) tmp=arr[j];
                }
                for(int j=i+1; j<i+3; j++) {
                    if(arr[j]>=arr[i]) continue out;
                    if(arr[j]>=tmp) tmp=arr[j];
                }
                ans += arr[i]-tmp;
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}