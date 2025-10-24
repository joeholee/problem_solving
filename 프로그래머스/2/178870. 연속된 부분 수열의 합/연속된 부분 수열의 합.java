class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int st = 0, en = 0;
        int sum = 0, len = sequence.length+1;
        while(true) {
            if(sum>=k) {
                if(sum==k) {
                    if(len>en-st) {
                        len=en-st;
                        answer[0]=st;
                        answer[1]=en-1;
                    }
                }
                sum-=sequence[st++];
            }
            else {
                if(en==sequence.length) break;
                sum+=sequence[en++];
            }
        }
        return answer;
    }
}