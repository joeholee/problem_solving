import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    private static int ans=0;
     
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
            System.out.print("#"+test_case+" ");
            System.out.println(hasMonotone(A) ? ans : -1);
        }
    }
     
    static boolean hasMonotone(int[] A) {
        int caseAns=0;
        for(int i=0; i<A.length; i++) {
            inner: for(int j=i+1; j<A.length; j++) {
                int tmp = A[i]*A[j];
                String tmpS = Integer.toString(tmp);
                for(int c=0; c<tmpS.length()-1; c++) {
                    if(tmpS.charAt(c)>tmpS.charAt(c+1)) continue inner;
                }
                if(tmp>caseAns) caseAns=tmp;
            }
        }
        ans=caseAns;
        return ans>0? true : false;
    }
}