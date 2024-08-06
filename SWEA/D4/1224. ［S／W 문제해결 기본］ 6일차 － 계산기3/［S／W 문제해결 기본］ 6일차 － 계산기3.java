import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
  
class Solution
{
   public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stc = new Stack<>();
        Stack<Integer> sti = new Stack<>();
        Map<Character,Integer> map = new HashMap<>();
        map.put('+',1);
        map.put('*',2);
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int len = Integer.parseInt(br.readLine());
            String input = br.readLine();
            sb.setLength(0);
            // infix -> postfix
            for(int i=0; i<len; i++) {
                if('0'<= input.charAt(i) && input.charAt(i)<='9') sb.append(input.charAt(i));
                else if(input.charAt(i)=='(') stc.push(input.charAt(i));
                else if(input.charAt(i)==')') {
                    char popItem = stc.pop();
                    while(popItem!='(') {
                        sb.append(popItem);
                        popItem=stc.pop();
                    }
                }
                else{
                    while(!stc.isEmpty() && stc.peek()!='(' && map.get(stc.peek())>=map.get(input.charAt(i)) ) sb.append(stc.pop());
                    stc.push(input.charAt(i));
                }
            }
            while(!stc.empty()) sb.append(stc.pop());
            // eval postfix
            for(int i=0; i<sb.length(); i++) {
                if('0'<=sb.charAt(i) && sb.charAt(i)<='9') sti.push(sb.charAt(i)-'0');
                else {
                    int num1 = sti.pop();
                    int num2 = sti.pop();
                    if(sb.charAt(i)=='+') sti.push(num1+num2);
                    else sti.push(num1*num2);
                }
            }
            System.out.println("#"+test_case+" "+sti.pop());
        }
    }
}