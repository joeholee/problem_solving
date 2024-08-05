import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= TC; test_case++)
        {
            Stack<Integer> st = new Stack<>();
            int K = Integer.parseInt(br.readLine());
            while(K>0) {
                K--;
                int input = Integer.parseInt(br.readLine());
                if(input!=0) st.push(input);
                else st.pop();
            }
            int sum=0;
            while(st.size()>0) sum+=st.pop();
            System.out.println("#"+test_case+" "+sum);
        }
    }
}