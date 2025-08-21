class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int x=0; x<=d; x+=k) {
            int y = (int) Math.sqrt((long)d*d-(long)x*x);
            answer += y/k+1;
        }
        return answer;
    }
}