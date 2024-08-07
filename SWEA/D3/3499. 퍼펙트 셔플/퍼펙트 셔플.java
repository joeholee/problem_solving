import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            sb.setLength(0);
            int N = Integer.parseInt(br.readLine());
            String[] cards = br.readLine().split(" ");
            for(int i=0; i<((N+1)/2); i++) q1.offer(cards[i]);
            for(int i=((N+1)/2); i<N; i++) q2.offer(cards[i]);
            while(!q1.isEmpty() && !q2.isEmpty()) sb.append(q1.poll() + " " + q2.poll() + " ");
            if(!q1.isEmpty()) sb.append(q1.poll());
            System.out.println("#"+test_case+" "+sb);
		}
	}
}