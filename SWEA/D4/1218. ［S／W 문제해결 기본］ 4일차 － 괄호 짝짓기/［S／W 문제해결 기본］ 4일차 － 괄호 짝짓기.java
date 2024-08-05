import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int len=Integer.parseInt(br.readLine());
            Stack<Character> st = new Stack<>();
            char[] input = br.readLine().toCharArray();
            if(len%2==1) {
                System.out.println("#"+test_case+" "+0);
                continue;
            }
            int idx=0;
            while(len>0) {
                if(input[idx]=='(' || input[idx]=='[' || input[idx]=='{' || input[idx]=='<') st.push(input[idx]);
                else if(input[idx]==')') {
                    if(!st.empty() && st.peek()=='(') st.pop();
                    else st.push(input[idx]);
                }
                else if(input[idx]==']') {
                    if(!st.empty() && st.peek()=='[') st.pop();
                    else st.push(input[idx]);
                }
                else if(input[idx]=='}') {
                    if(!st.empty() && st.peek()=='{') st.pop();
                    else st.push(input[idx]);
                }
                else {
                    if(!st.empty() && st.peek()=='<') st.pop();
                    else st.push(input[idx]);
                }
                len--;
                idx++;
            }
            if(!st.empty()) System.out.println("#"+test_case+" "+0);
            else System.out.println("#"+test_case+" "+1);
        }
    }
}