import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        long left=0, right=(long) n*times[times.length-1];
        while(left<=right) {
            long mid = (left+right)/2;
            long sum = 0;
            for(int i : times) sum+=mid/i;
            if(sum>=n) {
                right=mid-1;
                answer = Math.min(answer, mid);
            } else left=mid+1;
        }
        return answer;
    }
}