class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        int max = 0;
        for(int i : diffs) max = Math.max(max, i);
        int st=1, en=max;
        while(st<=en) {
            int mid = (st+en)/2;
            long tot = 0;
            for(int i=0; i<diffs.length; i++) {
                if(diffs[i]>mid&&i>0) {
                    tot+=(long) (diffs[i]-mid)*(times[i]+times[i-1]);
                    tot+=times[i];
                } else tot+=times[i];
            }
            if(tot>limit) st=mid+1;
            else {
                answer = Math.min(answer, mid);
                en=mid-1;
            }
        }
        return answer;
    }
}