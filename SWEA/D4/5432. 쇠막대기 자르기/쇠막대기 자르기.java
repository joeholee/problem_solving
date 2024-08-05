import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            char[] input = br.readLine().toCharArray();
            Stack<Character> st = new Stack<>();
            int ans=0;
            for(int i=0; i<input.length; i++) {
                if(input[i]=='(') st.push(input[i]);
                else {
                    if(input[i-1]=='(') {
                        st.pop();
                        ans+=st.size();
                    }
                    else {
                        st.pop();
                        ans++;
                    }
                }
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
}