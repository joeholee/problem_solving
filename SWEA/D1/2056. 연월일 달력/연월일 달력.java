import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        boolean isValid=false;
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            sb.setLength(0);
            String input = br.readLine();
            int Y = Integer.parseInt(input.substring(0,4));
            int M = Integer.parseInt(input.substring(4,6));
            int D = Integer.parseInt(input.substring(6,8));
            if(M<1||M>12) {
            	System.out.println("#"+test_case+" -1");
                continue;
            }
            switch(M) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if(1<=D && D<=31) isValid=true;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if(1<=D && D<=30) isValid=true;
                    break;
                case 2:
                    if(1<=D && D<=28) isValid=true;
            }
            if(!isValid) System.out.println("#"+test_case+" -1");
            else {
            	sb.append("#"+(char)(test_case+'0')+" "+input.substring(0,4)+"/"+input.substring(4,6)+"/"+input.substring(6,8));
                System.out.println(sb);
            }
            isValid=false;
		}
	}
}