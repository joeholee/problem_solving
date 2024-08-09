import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
        	String input = Integer.toString(i);
            int cnt=0;
            if(input.contains("3") || input.contains("6") || input.contains("9")) {
                for(char c : input.toCharArray()) {
                	if(c=='3' || c=='6' || c=='9') cnt++;
                }
                while(cnt>0) {
                	sb.append('-');
                    cnt--;
                }
            }
            else sb.append(input);
            sb.append(" ");
        }
        System.out.print(sb);
	}
}