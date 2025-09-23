import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville) pq.offer(i);
        int answer = 0;
        while(pq.size()>1 && pq.peek()<K) {
            answer++;
            int min = pq.poll();
            int nxt = pq.poll();
            pq.offer(min+2*nxt);
        }
        answer = (pq.peek()<K) ? -1 : answer;
        return answer;
    }
}