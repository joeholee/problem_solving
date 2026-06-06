import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        long st=0, en=(long) n*times[times.length-1];
        while(st<=en) {
            long mid = (st+en)/2;
            long sum = 0;
            for(int i : times) sum += (mid/i);
            if(sum>=n) {
                en=mid-1;
                answer = Math.min(answer,mid);
            } else st=mid+1;
        }
        return answer;
    }
}