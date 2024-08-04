import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[100][100];
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            for(int i=0; i<100; i++) arr[i] = br.readLine().toCharArray();
            boolean traverse=false;
            int len=100;
            int ans=0;
            while(len>1 && !traverse) {
                int start=0;
                int end = 100-len;
                for(int i=0; i<100; i++) {
                    for(int c=start; c<=end; c++) {
                        for(int t=0; t<len/2; t++) {
                            if(arr[i][c+t] != arr[i][c+len-1-t]) break;
                            else {
                                if(t==len/2 - 1) {
                                    ans = len;
                                    traverse = true;
                                    break;
                                }
                            }
                        }
                        for(int t=0; t<len/2; t++) {
                            if(arr[c+t][i] != arr[c+len-1-t][i]) break;
                            else {
                                if(t==len/2 - 1) {
                                    ans = len;
                                    traverse = true;
                                    break;
                                }
                            }
                        }
                    }
                    if(traverse) break;
                }
                len--;
            }
            System.out.println("#"+N+" "+ans);
        }
    }
}