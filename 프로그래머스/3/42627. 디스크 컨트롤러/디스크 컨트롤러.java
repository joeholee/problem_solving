import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int now = 0;
        int idx = 0;
        int len = jobs.length;
        Arrays.sort(jobs, (a,b) -> a[0]-b[0]); // req
        PriorityQueue<Job> pq = new PriorityQueue<>();
        while(idx<len || !pq.isEmpty()) {
            while(idx<len && jobs[idx][0]<=now) {
                pq.offer(new Job(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            if(!pq.isEmpty()) {
                Job cur = pq.poll();
                now += cur.time;
                answer += (now-cur.req);
            } else {
                now = jobs[idx][0];
            }
        }
        return (answer/len);
    }
}

class Job implements Comparable<Job> {
    int idx, req, time;
    
    Job(int idx, int req, int time) {
        this.idx = idx;
        this.req = req;
        this.time = time;
    }
    
    @Override
    public int compareTo(Job j) {
        if(time==j.time) return Integer.compare(req, j.req);
        return Integer.compare(time, j.time);
    }
}