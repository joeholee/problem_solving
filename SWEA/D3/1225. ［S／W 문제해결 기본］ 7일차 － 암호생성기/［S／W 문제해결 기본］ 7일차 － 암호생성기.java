import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int T = Integer.parseInt(br.readLine());
            String[] nums = br.readLine().split(" ");
            for(int i=0; i<8; i++) q.offer(Integer.parseInt(nums[i]));
            int dec=1;
            while(q.peek()>dec) {
                q.offer(q.poll() - dec++);
                if(dec==6) dec=1;
            }
            q.poll();
            q.offer(0);
            System.out.print("#"+T+" ");
            for(int i : q) System.out.print(i + " ");
            System.out.println();
            q.clear();
        }
    }
}