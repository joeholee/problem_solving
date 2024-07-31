import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int T = Integer.parseInt(st.nextToken());
            int[][] arr = new int[100][100];
            for(int i=0; i<100; i++) {
                String[] input = br.readLine().split(" ");
                for(int j=0; j<100; j++) arr[i][j]=Integer.parseInt(input[j]);
            }
            int ans=0;
            for(int i=0; i<100; i++) {
                int sum=0;
                for(int num : arr[i]) sum+=num;
                if(sum>ans) ans=sum;
            }
            for(int c=0; c<100; c++) {
                int sum=0;
                for(int r=0; r<100; r++) {
                    sum+=arr[r][c];
                }
                if(sum>ans) ans=sum;
            }
            int diag1=0,diag2=0;
            for(int i=0; i<100; i++) diag1+=arr[i][i];
            if(diag1>ans) ans=diag1;
            for(int i=0; i<100; i++) diag2+=arr[i][99-i];
            if(diag2>ans) ans=diag2;
            System.out.println("#"+T+" "+ans);
        }
    }
}