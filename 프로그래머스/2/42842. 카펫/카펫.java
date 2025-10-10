class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int width=0,height=0;
        int total = brown+yellow;
        for(int i=1; i*i<=total; i++) {
            if(total%i==0) {
                height=i;
                width=total/height;
                if((width-2)*(height-2)==yellow) {
                    answer[0]=width;
                    answer[1]=height;
                    break;
                }
            }
        }
        return answer;
    }
}