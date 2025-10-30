class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey>0) {
            int right = storey%10;
            storey/=10;
            if(right==5) {
                if(storey%10>=5) {
                    answer+=(10-right);
                    storey++;
                } else answer+=right;
            } else if(right>5) {
                answer+=(10-right);
                storey++;
            } else answer+=right;
        }
        return answer;
    }
}