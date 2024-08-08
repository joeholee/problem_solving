import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
            for(int i=1; i<N; i++) {
                int data = arr[i];
                int j;
                for(j=i-1; j>=0 && data<arr[j]; j--) arr[j+1]=arr[j];
                arr[j+1]=data;
            }
            System.out.print("#"+test_case+" ");
            for(int i : arr) System.out.print(i + " ");
            System.out.println();
        }
    }
}